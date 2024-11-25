package com.ains.groupit.calculateme.service.impl;

import com.ains.groupit.calculateme.dto.paginatedDTO.PaginatedBrickCalculationDTO;
import com.ains.groupit.calculateme.dto.request.BrickCalculationCalculationRequestDTO;
import com.ains.groupit.calculateme.dto.response.BrickCalculationResponseDTO;
import com.ains.groupit.calculateme.entity.BrickCalculationDetail;
import com.ains.groupit.calculateme.repository.BrickRepository;
import com.ains.groupit.calculateme.service.BrickCalculatorService;
import com.ains.groupit.calculateme.util.enums.CementRatio;
import com.ains.groupit.calculateme.util.mapper.BrickMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrickCalculatorServiceImpl implements BrickCalculatorService {

    private final BrickRepository brickRepository;
    private final BrickMapper brickMapper;

    @Override
    public BrickCalculationResponseDTO calculateBricks(BrickCalculationCalculationRequestDTO request) {
        // Map the request DTO to an entity
        BrickCalculationDetail entity = brickMapper.toEntity(request);

        // Extracting wall dimensions and brick dimensions
        double wallLength = entity.getWallLength();
        double wallHeight = entity.getWallHeight();
        double wallThickness = entity.getWallThickness();

        // Convert wall thickness from centimeters to meters if necessary
        if (wallThickness == 10) {
            wallThickness = 0.1; // 10 cm = 0.1 m
        } else if (wallThickness == 20) {
            wallThickness = 0.2; // 20 cm = 0.2 m
        }else {
            wallThickness = 0.3;
        }

        double brickLength = entity.getBrickLength();
        double brickWidth = entity.getBrickWidth();
        double brickHeight = entity.getBrickHeight();

        // 1. Calculate the wall volume
        double wallVolume = wallLength * wallHeight * wallThickness;

        // 2. Calculate the brick volume (including joint thickness of 0.01m)
        double brickVolume = (brickLength + 0.01) * (brickWidth + 0.01) * (brickHeight + 0.01);

        // 3. Calculate the number of bricks
        int numberOfBricks = (int) Math.ceil(wallVolume / brickVolume);

        // 4. Calculate mortar volume
        double bricksMortar = numberOfBricks * (brickLength * brickWidth * brickHeight); // Solid brick volume
        double netMortarVolume = wallVolume - bricksMortar; // Net mortar volume between bricks
        double adjustedMortarVolume = netMortarVolume + (netMortarVolume * 0.15); // Add 15% for wastage
        double mortarVolumeDry = adjustedMortarVolume + (adjustedMortarVolume * 0.25); // Add 25% for dry volume

        // 5. Calculate cement and sand quantities based on the selected ratio
        CementRatio ratioEnum = CementRatio.fromString(request.getCementRatio());
        double cementVolume = mortarVolumeDry / ratioEnum.getCementDivisor();
        double sandVolume = mortarVolumeDry * (ratioEnum.getSandDivisor() / ratioEnum.getCementDivisor());

        // 6. Calculate cement bags and sand weight
        int cementBags = (int) Math.ceil(cementVolume / 0.035); // 1 cement bag = 0.035 m³
        double sandQuantity = Math.round((sandVolume * 1500) / 1000 * 100.0) / 100.0; // Convert to tons (1500 kg/m³)

        // Populate the calculated values back into the entity
        entity.setNumberOfBricks(numberOfBricks);
        entity.setCementBags(cementBags);
        entity.setSandQuantity(sandQuantity);

        // Save the entity to the database
        brickRepository.save(entity);

        // Convert the entity back to a response DTO using the mapper
        return brickMapper.toResponseDTO(entity);
    }

    @Override
    public PaginatedBrickCalculationDTO getAllPaginatedBrickCalculator(int pageNo, int size) {
        Pageable pageable = PageRequest.of(pageNo, size);

        Page<BrickCalculationDetail> brickCalculationDetails;

        brickCalculationDetails = brickRepository.findAll(pageable);

        return new PaginatedBrickCalculationDTO(
                brickCalculationDetails.getContent(),
                brickCalculationDetails.getTotalElements(),
                brickCalculationDetails.getTotalPages(),
                pageNo
        );
    }
}

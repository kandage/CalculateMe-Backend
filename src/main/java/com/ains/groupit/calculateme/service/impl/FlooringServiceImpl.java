package com.ains.groupit.calculateme.service.impl;

import com.ains.groupit.calculateme.dto.paginatedDTO.PaginatedFlooringDTO;
import com.ains.groupit.calculateme.dto.request.FlooringRequestDTO;
import com.ains.groupit.calculateme.dto.response.FlooringResponseDTO;
import com.ains.groupit.calculateme.entity.FlooringDetail;
import com.ains.groupit.calculateme.repository.FlooringRepository;
import com.ains.groupit.calculateme.service.FlooringService;
import com.ains.groupit.calculateme.util.mapper.FlooringMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FlooringServiceImpl implements FlooringService {

    private final FlooringRepository flooringRepository;
    private final FlooringMapper flooringMapper;

    @Override
    public FlooringResponseDTO calculateAndSaveFlooring(FlooringRequestDTO requestDTO) {
        // Convert request DTO to FlooringDetail entity
        FlooringDetail flooringDetail = flooringMapper.toEntity(requestDTO);

        double floorLength = requestDTO.getFloorLength();
        double floorWidth = requestDTO.getFloorWidth();
        double tileLength = requestDTO.getTileLength();
        double tileWidth = requestDTO.getTileWidth();

        // Validate inputs
        if (floorLength <= 0 || floorWidth <= 0 || tileLength <= 0 || tileWidth <= 0) {
            return new FlooringResponseDTO(0, 0, 0, 0, 0, 0, 0);
        }

        // Calculate the tile area and floor area
        double tileArea = tileLength * tileWidth;
        double floorArea = floorLength * floorWidth;

        // Calculate the number of tiles required
        int numTiles = (int) Math.ceil(floorArea / tileArea);

        // Calculate the volume of bedding with thickness 0.07m
        double volumeWithBedding = floorArea * 0.07;

        // Calculate the number of cement bags (each bag is 0.035 cubic meters)
        int cementBags = (int) Math.ceil((volumeWithBedding / 7) / 0.035);

        // Calculate the quantity of sand (density of sand = 1550 kg/m³)
        double sandQuantity = Math.round((((volumeWithBedding * 6) / 7) * 1550) * 100) / 100.0;

        // Add calculated values to the entity
        flooringDetail.setNumberOfTiles(numTiles);
        flooringDetail.setCementBags(cementBags);
        flooringDetail.setSandQuantity(sandQuantity);

        // Save the entity to the database
        flooringRepository.save(flooringDetail);

        // Map the entity to the response DTO using the mapper
        return flooringMapper.toResponseDTO(flooringDetail);
    }

    @Override
    public PaginatedFlooringDTO getAllPaginatedFlooringDetails(String searchText, int pageNo, int size) {
        Pageable pageable = PageRequest.of(pageNo, size);

        Page<FlooringDetail> flooringDetails = null;
        if (searchText == null || searchText.isEmpty()) {
            flooringDetails = flooringRepository.findAll(pageable);
        }

        assert flooringDetails != null;
        return new PaginatedFlooringDTO(
                flooringDetails.getContent(),
                flooringDetails.getTotalElements(),
                flooringDetails.getTotalPages(),
                pageNo
        );
    }
}

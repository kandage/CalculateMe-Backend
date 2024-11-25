package com.ains.groupit.calculateme.service.impl;

import com.ains.groupit.calculateme.dto.paginatedDTO.PaginatedWaterTankCalculationDTO;
import com.ains.groupit.calculateme.dto.request.WaterTankCalculationRequestDTO;
import com.ains.groupit.calculateme.dto.response.WaterTankCalculationResponseDTO;
import com.ains.groupit.calculateme.entity.WaterTankDetail;
import com.ains.groupit.calculateme.repository.WaterTankRepository;
import com.ains.groupit.calculateme.service.WaterTankService;
import com.ains.groupit.calculateme.util.mapper.WaterTankMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WaterTankServiceImpl implements WaterTankService {

    private final WaterTankRepository waterTankRepository;
    private final WaterTankMapper waterTankMapper;

    @Override
    public WaterTankCalculationResponseDTO calculateWaterTank(WaterTankCalculationRequestDTO requestDTO) {
        double length = requestDTO.getLength();
        double width = requestDTO.getWidth();
        double depth = requestDTO.getDepth();

        // Validate inputs
        if (length <= 0 || width <= 0 || depth <= 0) {
            return new WaterTankCalculationResponseDTO(0, 0, 0, 0, 0);
        }

        // Calculate volume (m³) and capacity (liters)
        double volume = length * width * depth;
        double capacity = volume * 1000; // 1 cubic meter = 1000 liters

        // Map input to entity and set calculated values
        WaterTankDetail waterTankDetails = waterTankMapper.toEntity(requestDTO);
        waterTankDetails.setVolume(volume);
        waterTankDetails.setCapacity(capacity);

        // Save the entity
        WaterTankDetail savedDetails = waterTankRepository.save(waterTankDetails);

        // Map saved entity to response DTO
        return waterTankMapper.toResponseDTO(savedDetails);
    }

    @Override
    public PaginatedWaterTankCalculationDTO getAllPaginatedWaterTankDetails(String searchText, int pageNo, int size) {
        Pageable pageable = PageRequest.of(pageNo, size);

        Page<WaterTankDetail> waterTankDetails = null;
        if (searchText == null || searchText.isEmpty()) {
            waterTankDetails = waterTankRepository.findAll(pageable);
        }

        assert waterTankDetails != null;
        return new PaginatedWaterTankCalculationDTO(
                waterTankDetails.getContent(),
                waterTankDetails.getTotalElements(),
                waterTankDetails.getTotalPages(),
                pageNo
        );
    }
}

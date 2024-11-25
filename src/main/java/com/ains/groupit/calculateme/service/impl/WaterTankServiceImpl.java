package com.ains.groupit.calculateme.service.impl;

import com.ains.groupit.calculateme.dto.request.WaterTankCalculationRequestDTO;
import com.ains.groupit.calculateme.dto.response.WaterTankCalculationResponseDTO;
import com.ains.groupit.calculateme.entity.WaterTankDetail;
import com.ains.groupit.calculateme.repository.WaterTankRepository;
import com.ains.groupit.calculateme.service.WaterTankService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WaterTankServiceImpl implements WaterTankService {

    private final WaterTankRepository waterTankRepository;

    @Override
    public WaterTankCalculationResponseDTO calculateWaterTank(WaterTankCalculationRequestDTO requestDTO) {
        double length = requestDTO.getLength();
        double width = requestDTO.getWidth();
        double depth = requestDTO.getDepth();

        // Validate inputs
        if (length <= 0 || width <= 0 || depth <= 0) {
            return new WaterTankCalculationResponseDTO(0, 0, "All inputs should be positive.");
        }

        // Calculate volume (m³) and capacity (liters)
        double volume = length * width * depth;
        double capacity = volume * 1000; // 1 cubic meter = 1000 liters


        WaterTankDetail waterTankDetails = new WaterTankDetail(null, length, width, depth, volume, capacity);
        waterTankRepository.save(waterTankDetails);

        return new WaterTankCalculationResponseDTO(volume, capacity, "Calculation successful and data saved.");
    }
}

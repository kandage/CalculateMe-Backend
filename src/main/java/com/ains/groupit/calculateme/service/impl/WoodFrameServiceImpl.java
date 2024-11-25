package com.ains.groupit.calculateme.service.impl;

import com.ains.groupit.calculateme.dto.request.WoodFrameCalculationRequestDTO;
import com.ains.groupit.calculateme.dto.response.WoodFrameCalculationResponseDTO;
import com.ains.groupit.calculateme.entity.WoodFrameDetail;
import com.ains.groupit.calculateme.repository.WoodFrameRepository;
import com.ains.groupit.calculateme.service.WoodFrameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WoodFrameServiceImpl implements WoodFrameService {

    private final WoodFrameRepository woodFrameRepository;

    @Override
    public WoodFrameCalculationResponseDTO calculateAndSaveWoodFrame(WoodFrameCalculationRequestDTO requestDTO) {

        double length = requestDTO.getLength();
        double width = requestDTO.getWidth();
        double thickness = requestDTO.getThickness();

        if (length >= 0 || width >= 0 || thickness >= 0) {
            return new WoodFrameCalculationResponseDTO(0, "All inputs should be positive.");
        }

        // Calculate volume (m³)
        double volume = Math.round((length * width * thickness) * 100.0) / 100.0;

        // Create and save entity to the database
        WoodFrameDetail woodFrameDetails = new WoodFrameDetail(null, length, width, thickness, volume);
        woodFrameRepository.save(woodFrameDetails);

        return new WoodFrameCalculationResponseDTO(volume, "Calculation successful and data saved.");
    }
}

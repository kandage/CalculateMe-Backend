package com.ains.groupit.calculateme.service.impl;

import com.ains.groupit.calculateme.dto.request.WoodFrameRequestDTO;
import com.ains.groupit.calculateme.dto.response.WoodFrameResponseDTO;
import com.ains.groupit.calculateme.entity.WoodFrameDetail;
import com.ains.groupit.calculateme.repository.WoodFrameRepository;
import com.ains.groupit.calculateme.service.WoodFrameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WoodFrameServiceImpl implements WoodFrameService {

    @Autowired
    private WoodFrameRepository woodFrameRepository;

    @Override
    public WoodFrameResponseDTO calculateAndSaveWoodFrame(WoodFrameRequestDTO requestDTO) {
        System.out.println("requestDTO = " + requestDTO);
        double length = requestDTO.getLength();
        double width = requestDTO.getWidth();
        double thickness = requestDTO.getThickness();

        // Validate inputs
        if (length >= 0 || width >= 0 || thickness >= 0) {
            return new WoodFrameResponseDTO(0, "All inputs should be positive.");
        }

        // Calculate volume (m³)
        double volume = Math.round((length * width * thickness) * 100.0) / 100.0;

        // Create and save entity to the database
        WoodFrameDetail woodFrameDetails = new WoodFrameDetail(null, length, width, thickness, volume);
        woodFrameRepository.save(woodFrameDetails);

        // Create response DTO
        return new WoodFrameResponseDTO(volume, "Calculation successful and data saved.");
    }
}

package com.ains.groupit.calculateme.service.impl;

import com.ains.groupit.calculateme.dto.request.AntiTermiteRequestDTO;
import com.ains.groupit.calculateme.dto.response.AntiTermiteResponseDTO;
import com.ains.groupit.calculateme.entity.AntiTermiteDetail;
import com.ains.groupit.calculateme.repository.AntiTermiteRepository;
import com.ains.groupit.calculateme.service.AntiTermiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AntiTermiteServiceImpl implements AntiTermiteService {

    @Autowired
    private AntiTermiteRepository antiTermiteRepository;

    @Override
    public AntiTermiteResponseDTO calculateAndSaveAntiTermite(AntiTermiteRequestDTO requestDTO) {
        double length = requestDTO.getLength();
        double width = requestDTO.getWidth();

        // Validate inputs
        if (length <= 0 || width <= 0) {
            return new AntiTermiteResponseDTO(0, "All inputs should be positive.");
        }

        // Calculate the quantity
        double area = length * width;
        double quantity = area * 30;

        // Create and save entity to the database
        AntiTermiteDetail details = new AntiTermiteDetail(null, length, width, quantity);
        antiTermiteRepository.save(details);

        // Create response DTO
        return new AntiTermiteResponseDTO(quantity, "Calculation successful and data saved.");
    }
}

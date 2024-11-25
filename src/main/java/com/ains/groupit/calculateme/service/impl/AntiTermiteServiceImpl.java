package com.ains.groupit.calculateme.service.impl;

import com.ains.groupit.calculateme.dto.paginatedDTO.PaginatedAntiTermiteCalculationDTO;
import com.ains.groupit.calculateme.dto.request.AntiTermiteCalculationRequestDTO;
import com.ains.groupit.calculateme.dto.response.AntiTermiteCalculationResponseDTO;
import com.ains.groupit.calculateme.entity.AntiTermiteDetail;
import com.ains.groupit.calculateme.repository.AntiTermiteRepository;
import com.ains.groupit.calculateme.service.AntiTermiteService;
import com.ains.groupit.calculateme.util.mapper.AntiTermiteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AntiTermiteServiceImpl implements AntiTermiteService {

    private final AntiTermiteRepository antiTermiteRepository;
    private final AntiTermiteMapper antiTermiteMapper;

    @Override
    public AntiTermiteCalculationResponseDTO calculateAndSaveAntiTermite(AntiTermiteCalculationRequestDTO requestDTO) {
        // Validate inputs
        if (requestDTO.getLength() <= 0 || requestDTO.getWidth() <= 0) {
            throw new IllegalArgumentException("Length and width must be greater than zero.");
        }

        // Calculate area and quantity
        double area = requestDTO.getLength() * requestDTO.getWidth();
        double quantity = area * 30;

        // Convert request DTO to entity using mapper
        AntiTermiteDetail details = antiTermiteMapper.toEntity(requestDTO);
        details.setQuantity(quantity);

        // Save the entity to the database
        AntiTermiteDetail savedDetail = antiTermiteRepository.save(details);

        // Use mapper to convert saved entity to response DTO
        return antiTermiteMapper.toResponseDTO(savedDetail);
    }

    @Override
    public PaginatedAntiTermiteCalculationDTO getAllAntiTermites(int pageNo, int size) {
        Pageable pageable = PageRequest.of(pageNo, size);

        Page<AntiTermiteDetail> antiTermiteDetails;

        antiTermiteDetails = antiTermiteRepository.findAll(pageable);

        return new PaginatedAntiTermiteCalculationDTO(
                antiTermiteDetails.getContent(),
                antiTermiteDetails.getTotalElements(),
                antiTermiteDetails.getTotalPages(),
                pageNo
        );
    }
}

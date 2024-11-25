package com.ains.groupit.calculateme.service.impl;

import com.ains.groupit.calculateme.dto.paginatedDTO.PaginatedWoodFrameCalculationDTO;
import com.ains.groupit.calculateme.dto.request.WoodFrameCalculationRequestDTO;
import com.ains.groupit.calculateme.dto.response.WoodFrameCalculationResponseDTO;
import com.ains.groupit.calculateme.entity.WoodFrameDetail;
import com.ains.groupit.calculateme.repository.WoodFrameRepository;
import com.ains.groupit.calculateme.service.WoodFrameService;
import com.ains.groupit.calculateme.util.mapper.WoodFrameMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WoodFrameServiceImpl implements WoodFrameService {

    private final WoodFrameRepository woodFrameRepository;

    private final WoodFrameMapper woodFrameMapper;

    @Override
    public WoodFrameCalculationResponseDTO calculateAndSaveWoodFrame(WoodFrameCalculationRequestDTO requestDTO) {
        double length = requestDTO.getLength();
        double width = requestDTO.getWidth();
        double thickness = requestDTO.getThickness();

        // Validate inputs
        if (length <= 0 || width <= 0 || thickness <= 0) {
            return new WoodFrameCalculationResponseDTO(0, 0, 0, 0);
        }

        // Calculate volume (m³) and round to 2 decimal places
        double volume = Math.round((length * width * thickness) * 100.0) / 100.0;

        // Map input DTO to entity and set calculated volume
        WoodFrameDetail woodFrameDetails = woodFrameMapper.toEntity(requestDTO);
        woodFrameDetails.setVolume(volume);

        // Save the entity to the database
        WoodFrameDetail savedDetails = woodFrameRepository.save(woodFrameDetails);

        // Map saved entity to response DTO
        return woodFrameMapper.toResponseDTO(savedDetails);
    }

    @Override
    public PaginatedWoodFrameCalculationDTO getAllPaginatedWoodFrameDetails(String searchText, int pageNo, int size) {
        Pageable pageable = PageRequest.of(pageNo, size);

        Page<WoodFrameDetail> woodFrameDetails = null;
        if (searchText == null || searchText.isEmpty()) {
            woodFrameDetails = woodFrameRepository.findAll(pageable);
        }

        assert woodFrameDetails != null;
        return new PaginatedWoodFrameCalculationDTO(
                woodFrameDetails.getContent(),
                woodFrameDetails.getTotalElements(),
                woodFrameDetails.getTotalPages(),
                pageNo
        );
    }
}

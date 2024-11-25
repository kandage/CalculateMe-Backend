package com.ains.groupit.calculateme.service.impl;

import com.ains.groupit.calculateme.dto.paginatedDTO.PaginatedSteelQuantityCalculationDTO;
import com.ains.groupit.calculateme.dto.request.SteelQuantityCalculationRequestDTO;
import com.ains.groupit.calculateme.dto.response.SteelQuantityCalculationResponseDTO;
import com.ains.groupit.calculateme.entity.SteelQuantityDetails;
import com.ains.groupit.calculateme.repository.SteelQuantityRepository;
import com.ains.groupit.calculateme.service.SteelQuantityService;
import com.ains.groupit.calculateme.util.enums.MemberType;
import com.ains.groupit.calculateme.util.mapper.SteelQuantityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SteelQuantityServiceImpl implements SteelQuantityService {

    private final SteelQuantityRepository steelQuantityRepository;
    private final SteelQuantityMapper steelQuantityMapper;

    @Override
    public SteelQuantityCalculationResponseDTO calculateAndSaveSteelQuantity(SteelQuantityCalculationRequestDTO requestDTO) {
        // Map request DTO to entity
        SteelQuantityDetails steelQuantityDetails = steelQuantityMapper.toEntity(requestDTO);

        // Perform steel weight calculation (example formula)
        double concreteQuantity = requestDTO.getConcreteQuantity();
        double steelWeight = calculateSteelWeight(requestDTO.getMemberType(), concreteQuantity);

        // Set calculated values
        steelQuantityDetails.setSteelWeight(steelWeight);

        // Save the entity
        SteelQuantityDetails savedDetails = steelQuantityRepository.save(steelQuantityDetails);

        // Convert saved entity to response DTO
        return steelQuantityMapper.toResponseDTO(savedDetails);
    }

    @Override
    public PaginatedSteelQuantityCalculationDTO getAllPaginatedSteelQuantityDetails(String searchText, int pageNo, int size) {
        Pageable pageable = PageRequest.of(pageNo, size);

        Page<SteelQuantityDetails> steelQuantityDetails = null;
        if (searchText == null || searchText.isEmpty()) {
            steelQuantityDetails = steelQuantityRepository.findAll(pageable);
        }

        assert steelQuantityDetails != null;
        return new PaginatedSteelQuantityCalculationDTO(
                steelQuantityDetails.getContent(),
                steelQuantityDetails.getTotalElements(),
                steelQuantityDetails.getTotalPages(),
                pageNo
        );
    }


    private double calculateSteelWeight(String memberType, double concreteQuantity) {
        MemberType type = MemberType.fromValue(memberType);
        return type.getMultiplier() * concreteQuantity;
    }
}

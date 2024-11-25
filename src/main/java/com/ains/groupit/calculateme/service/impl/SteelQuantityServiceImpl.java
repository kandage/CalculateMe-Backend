package com.ains.groupit.calculateme.service.impl;

import com.ains.groupit.calculateme.dto.paginatedDTO.PaginatedSteelQuantityCalculationDTO;
import com.ains.groupit.calculateme.dto.request.SteelQuantityCalculationRequestDTO;
import com.ains.groupit.calculateme.dto.response.SteelQuantityCalculationResponseDTO;
import com.ains.groupit.calculateme.entity.SteelQuantityDetails;
import com.ains.groupit.calculateme.repository.SteelQuantityRepository;
import com.ains.groupit.calculateme.service.SteelQuantityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SteelQuantityServiceImpl implements SteelQuantityService {

    private final SteelQuantityRepository steelQuantityRepository;

    @Override
    public SteelQuantityCalculationResponseDTO calculateAndSaveSteelQuantity(SteelQuantityCalculationRequestDTO requestDTO) {

        double steelWeight = calculateSteelWeight(requestDTO.getMType(), requestDTO.getConcreteQuantity());

        SteelQuantityDetails steelQuantity = new SteelQuantityDetails(requestDTO.getMType(), requestDTO.getConcreteQuantity(), steelWeight);

        steelQuantity = steelQuantityRepository.save(steelQuantity);

        return new SteelQuantityCalculationResponseDTO(steelQuantity.getMemberType(), steelQuantity.getConcreteQuantity(), steelQuantity.getSteelWeight());
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
        switch (memberType) {
            case "Footing":
            case "Slab":
                return 80 * concreteQuantity;
            case "Beam":
                return 160 * concreteQuantity;
            case "Column":
                return 110 * concreteQuantity;
            case "StairCase":
                return 85 * concreteQuantity;
            case "Lintle/Coping":
                return 50 * concreteQuantity;
            case "Retaining Wall":
                return 60 * concreteQuantity;
            default:
                throw new IllegalStateException("Unexpected value: " + memberType);
        }
    }
}

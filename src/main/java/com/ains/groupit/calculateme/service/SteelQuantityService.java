package com.ains.groupit.calculateme.service;

import com.ains.groupit.calculateme.dto.paginatedDTO.PaginatedSteelQuantityCalculationDTO;
import com.ains.groupit.calculateme.dto.request.SteelQuantityCalculationRequestDTO;
import com.ains.groupit.calculateme.dto.response.SteelQuantityCalculationResponseDTO;

public interface SteelQuantityService {
    SteelQuantityCalculationResponseDTO calculateAndSaveSteelQuantity(SteelQuantityCalculationRequestDTO requestDTO);

    PaginatedSteelQuantityCalculationDTO getAllPaginatedSteelQuantityDetails(String searchText, int pageNo, int size);
}

package com.ains.groupit.calculateme.service;

import com.ains.groupit.calculateme.dto.paginatedDTO.PaginatedStairCaseCalculationDTO;
import com.ains.groupit.calculateme.dto.request.StairCaseCalculationRequestDTO;
import com.ains.groupit.calculateme.dto.response.StairCaseCalculationResponseDTO;

public interface StairCaseService {
    StairCaseCalculationResponseDTO calculateStairCase(StairCaseCalculationRequestDTO stairCaseDTO);

    PaginatedStairCaseCalculationDTO getAllPaginatedStairCaseDetails(int pageNo, int size);
}
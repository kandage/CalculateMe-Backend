package com.ains.groupit.calculateme.service;

import com.ains.groupit.calculateme.dto.paginatedDTO.PaginatedBrickCalculationDTO;
import com.ains.groupit.calculateme.dto.request.BrickCalculationCalculationRequestDTO;
import com.ains.groupit.calculateme.dto.response.BrickCalculationResponseDTO;

public interface BrickCalculatorService {
    BrickCalculationResponseDTO calculateBricks(BrickCalculationCalculationRequestDTO request);

    PaginatedBrickCalculationDTO getAllPaginatedBrickCalculator(String searchText, int pageNo, int size);
}

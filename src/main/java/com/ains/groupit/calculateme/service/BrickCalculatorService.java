package com.ains.groupit.calculateme.service;

import com.ains.groupit.calculateme.dto.paginatedDTO.PaginatedBrickCalculatorDTO;
import com.ains.groupit.calculateme.dto.request.BrickCalculationRequestDTO;
import com.ains.groupit.calculateme.dto.response.BrickCalculationResponseDTO;

public interface BrickCalculatorService {
    BrickCalculationResponseDTO calculateBricks(BrickCalculationRequestDTO request);

    PaginatedBrickCalculatorDTO getAllPaginatedBrickCalculator(String searchText, int pageNo, int size);
}

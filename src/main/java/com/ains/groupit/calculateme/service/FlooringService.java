package com.ains.groupit.calculateme.service;

import com.ains.groupit.calculateme.dto.paginatedDTO.PaginatedFlooringCalculationDTO;
import com.ains.groupit.calculateme.dto.request.FlooringCalculationRequestDTO;
import com.ains.groupit.calculateme.dto.response.FlooringCalculationResponseDTO;

public interface FlooringService {
    FlooringCalculationResponseDTO calculateAndSaveFlooring(FlooringCalculationRequestDTO requestDTO);

    PaginatedFlooringCalculationDTO getAllPaginatedFlooringDetails(String searchText, int pageNo, int size);
}

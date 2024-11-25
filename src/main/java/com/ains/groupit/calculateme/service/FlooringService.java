package com.ains.groupit.calculateme.service;

import com.ains.groupit.calculateme.dto.paginatedDTO.PaginatedFlooringDTO;
import com.ains.groupit.calculateme.dto.request.FlooringCalculationRequestDTO;
import com.ains.groupit.calculateme.dto.response.FlooringResponseDTO;

public interface FlooringService {
    FlooringResponseDTO calculateAndSaveFlooring(FlooringCalculationRequestDTO requestDTO);

    PaginatedFlooringDTO getAllPaginatedFlooringDetails(String searchText, int pageNo, int size);
}

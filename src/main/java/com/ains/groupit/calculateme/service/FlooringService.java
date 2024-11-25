package com.ains.groupit.calculateme.service;

import com.ains.groupit.calculateme.dto.paginatedDTO.PaginatedFlooringDTO;
import com.ains.groupit.calculateme.dto.request.FlooringRequestDTO;
import com.ains.groupit.calculateme.dto.response.FlooringResponseDTO;

public interface FlooringService {
    FlooringResponseDTO calculateAndSaveFlooring(FlooringRequestDTO requestDTO);

    PaginatedFlooringDTO getAllPaginatedFlooringDetails(String searchText, int pageNo, int size);
}

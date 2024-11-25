package com.ains.groupit.calculateme.service;

import com.ains.groupit.calculateme.dto.paginatedDTO.PaginatedAntiTermiteDTO;
import com.ains.groupit.calculateme.dto.request.AntiTermiteRequestDTO;
import com.ains.groupit.calculateme.dto.response.AntiTermiteResponseDTO;

public interface AntiTermiteService {
    AntiTermiteResponseDTO calculateAndSaveAntiTermite(AntiTermiteRequestDTO requestDTO);

    PaginatedAntiTermiteDTO getAllAntiTermites(String searchText, int pageNo, int size);
}

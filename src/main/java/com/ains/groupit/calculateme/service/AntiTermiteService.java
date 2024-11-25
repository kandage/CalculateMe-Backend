package com.ains.groupit.calculateme.service;

import com.ains.groupit.calculateme.dto.paginatedDTO.PaginatedAntiTermiteCalculationDTO;
import com.ains.groupit.calculateme.dto.request.AntiTermiteCalculationRequestDTO;
import com.ains.groupit.calculateme.dto.response.AntiTermiteCalculationResponseDTO;

public interface AntiTermiteService {
    AntiTermiteCalculationResponseDTO calculateAndSaveAntiTermite(AntiTermiteCalculationRequestDTO requestDTO);

    PaginatedAntiTermiteCalculationDTO getAllAntiTermites(String searchText, int pageNo, int size);
}

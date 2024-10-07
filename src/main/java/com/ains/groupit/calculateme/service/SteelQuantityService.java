package com.ains.groupit.calculateme.service;

import com.ains.groupit.calculateme.dto.request.SteelQuantityRequestDTO;
import com.ains.groupit.calculateme.dto.response.SteelQuantityResponseDTO;

public interface SteelQuantityService {
    SteelQuantityResponseDTO calculateAndSaveSteelQuantity(SteelQuantityRequestDTO requestDTO);
}

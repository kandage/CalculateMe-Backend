package com.ains.groupit.calculateme.service;

import com.ains.groupit.calculateme.dto.request.AntiTermiteRequestDTO;
import com.ains.groupit.calculateme.dto.response.AntiTermiteResponseDTO;

public interface AntiTermiteService {
    AntiTermiteResponseDTO calculateAndSaveAntiTermite(AntiTermiteRequestDTO requestDTO);
}

package com.ains.groupit.calculateme.service;

import com.ains.groupit.calculateme.dto.request.WoodFrameCalculationRequestDTO;
import com.ains.groupit.calculateme.dto.response.WoodFrameCalculationResponseDTO;

public interface WoodFrameService {
    WoodFrameCalculationResponseDTO calculateAndSaveWoodFrame(WoodFrameCalculationRequestDTO requestDTO);
}

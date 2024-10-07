package com.ains.groupit.calculateme.service;

import com.ains.groupit.calculateme.dto.request.WoodFrameRequestDTO;
import com.ains.groupit.calculateme.dto.response.WoodFrameResponseDTO;

public interface WoodFrameService {
    WoodFrameResponseDTO calculateAndSaveWoodFrame(WoodFrameRequestDTO requestDTO);
}

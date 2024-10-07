package com.ains.groupit.calculateme.service;

import com.ains.groupit.calculateme.dto.request.WaterTankRequestDTO;
import com.ains.groupit.calculateme.dto.response.WaterTankResponseDTO;

public interface WaterTankService {
    WaterTankResponseDTO calculateWaterTank(WaterTankRequestDTO requestDTO);
}
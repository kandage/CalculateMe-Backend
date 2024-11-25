package com.ains.groupit.calculateme.service;

import com.ains.groupit.calculateme.dto.request.WaterTankCalculationRequestDTO;
import com.ains.groupit.calculateme.dto.response.WaterTankCalculationResponseDTO;

public interface WaterTankService {
    WaterTankCalculationResponseDTO calculateWaterTank(WaterTankCalculationRequestDTO requestDTO);
}

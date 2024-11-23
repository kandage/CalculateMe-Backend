package com.ains.groupit.calculateme.service;

import com.ains.groupit.calculateme.dto.request.BrickCalculationRequestDTO;
import com.ains.groupit.calculateme.dto.response.BrickCalculationResponseDTO;

public interface BrickCalculatorService {
    BrickCalculationResponseDTO calculateBricks(BrickCalculationRequestDTO request);
}

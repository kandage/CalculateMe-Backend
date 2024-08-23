package com.ains.groupit.calculateme.service;

import com.ains.groupit.calculateme.dto.request.BrickCalculationRequest;
import com.ains.groupit.calculateme.dto.response.BrickCalculationResponse;

public interface BrickCalculatorService {
    BrickCalculationResponse calculateBricks(BrickCalculationRequest request);
}

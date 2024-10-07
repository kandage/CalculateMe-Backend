package com.ains.groupit.calculateme.service;

import com.ains.groupit.calculateme.dto.request.StairCaseDTO;
import com.ains.groupit.calculateme.dto.response.StairCaseResponseDTO;

public interface StairCaseService {
    StairCaseResponseDTO calculateStairCase(StairCaseDTO stairCaseDTO);
}

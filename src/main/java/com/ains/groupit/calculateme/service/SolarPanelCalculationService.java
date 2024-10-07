package com.ains.groupit.calculateme.service;

import com.ains.groupit.calculateme.dto.request.SolarPanelCalculationDTO;
import com.ains.groupit.calculateme.entity.SolarPanelDetail;

public interface SolarPanelCalculationService {
    SolarPanelDetail calculate(SolarPanelCalculationDTO calculationDTO);
}

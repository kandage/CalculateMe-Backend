package com.ains.groupit.calculateme.service.impl;

import com.ains.groupit.calculateme.dto.request.SolarPanelCalculationDTO;
import com.ains.groupit.calculateme.entity.SolarPanelDetail;
import com.ains.groupit.calculateme.repository.SolarPanelCalculationRepository;
import com.ains.groupit.calculateme.service.SolarPanelCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SolarPanelCalculationServiceImpl implements SolarPanelCalculationService {

    @Autowired
    private SolarPanelCalculationRepository repository;

    @Override
    public SolarPanelDetail calculate(SolarPanelCalculationDTO calculationDTO) {
        double unitCount = calculationDTO.getUnits();
        String typeOfTheMember = calculationDTO.getConsumptionType();

        // Calculate daily consumption based on type
        double dailyConsumption = (typeOfTheMember.equalsIgnoreCase("Monthly")) ?
                Math.round((unitCount / 30) * 100.0) / 100.0 :
                Math.round((unitCount / 365) * 100.0) / 100.0;

        // Calculate rooftop capacity and other values
        double rooftopCapacity = Math.round((dailyConsumption / 4.5) * 100.0) / 100.0;
        int panelNo = (int) Math.round(rooftopCapacity * 3);
        double areaRequired = Math.round((rooftopCapacity * 95) * 100.0) / 100.0;

        // Create and save the entity
        SolarPanelDetail calculation = new SolarPanelDetail();
        calculation.setUnits(unitCount);
        calculation.setConsumptionType(typeOfTheMember);
        calculation.setDailyConsumption(dailyConsumption);
        calculation.setRooftopCapacity(rooftopCapacity);
        calculation.setPanelCount(panelNo);
        calculation.setAreaRequired(areaRequired);

        return repository.save(calculation);
    }
}

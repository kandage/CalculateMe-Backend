package com.ains.groupit.calculateme.controller;

import com.ains.groupit.calculateme.dto.request.SolarPanelCalculationDTO;
import com.ains.groupit.calculateme.entity.SolarPanelDetail;
import com.ains.groupit.calculateme.service.SolarPanelCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/solar-calculator")
public class SolarPanelCalculationController {

    @Autowired
    private SolarPanelCalculationService service;

    @PostMapping("/calculate")
    public SolarPanelDetail calculateSolarPanels(@RequestBody SolarPanelCalculationDTO calculationDTO) {
        return service.calculate(calculationDTO);
    }
}

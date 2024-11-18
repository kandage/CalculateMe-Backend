package com.ains.groupit.calculateme.controller;

import com.ains.groupit.calculateme.dto.request.SolarPanelCalculationDTO;
import com.ains.groupit.calculateme.entity.SolarPanelDetail;
import com.ains.groupit.calculateme.service.SolarPanelCalculationService;
import com.ains.groupit.calculateme.util.common.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/solar-calculator")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class SolarPanelCalculationController {

    private final SolarPanelCalculationService service;

    @PostMapping("/calculate")
    public ResponseEntity<StandardResponse<SolarPanelDetail>> calculateSolarPanels(
            @RequestBody SolarPanelCalculationDTO calculationDTO) {

        SolarPanelDetail solarPanelDetail = service.calculate(calculationDTO);

        StandardResponse<SolarPanelDetail> response = new StandardResponse<>(
                HttpStatus.OK.value(),
                "Solar panel calculation successful",
                solarPanelDetail
        );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

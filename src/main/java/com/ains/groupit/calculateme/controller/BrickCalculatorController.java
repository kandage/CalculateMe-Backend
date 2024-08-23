package com.ains.groupit.calculateme.controller;

import com.ains.groupit.calculateme.dto.request.BrickCalculationRequest;
import com.ains.groupit.calculateme.dto.response.BrickCalculationResponse;
import com.ains.groupit.calculateme.service.BrickCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/brick-calculator")
public class BrickCalculatorController {

    @Autowired
    private BrickCalculatorService brickCalculatorService;

    @PostMapping("/calculate")
    public BrickCalculationResponse calculateBricks(@RequestBody BrickCalculationRequest request) {
        return brickCalculatorService.calculateBricks(request);
    }
}
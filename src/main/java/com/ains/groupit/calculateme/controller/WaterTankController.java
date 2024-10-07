package com.ains.groupit.calculateme.controller;

import com.ains.groupit.calculateme.dto.request.WaterTankRequestDTO;
import com.ains.groupit.calculateme.dto.response.WaterTankResponseDTO;
import com.ains.groupit.calculateme.service.WaterTankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/water-tank")
public class WaterTankController {

    @Autowired
    private WaterTankService waterTankService;

    @PostMapping("/calculate")
    public WaterTankResponseDTO calculateWaterTank(@RequestBody WaterTankRequestDTO requestDTO) {
        return waterTankService.calculateWaterTank(requestDTO);
    }
}

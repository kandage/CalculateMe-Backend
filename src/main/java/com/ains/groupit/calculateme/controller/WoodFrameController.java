package com.ains.groupit.calculateme.controller;

import com.ains.groupit.calculateme.dto.request.WoodFrameRequestDTO;
import com.ains.groupit.calculateme.dto.response.WoodFrameResponseDTO;
import com.ains.groupit.calculateme.service.WaterTankService;
import com.ains.groupit.calculateme.service.WoodFrameService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/wood-frame")
public class WoodFrameController {

    @Autowired
    private WoodFrameService woodFrameService;

    @PostMapping("/calculate")
    public WoodFrameResponseDTO calculateWoodFrame(@RequestBody WoodFrameRequestDTO requestDTO) {
        System.out.println("Received Request DTO: " + requestDTO);
        return woodFrameService.calculateAndSaveWoodFrame(requestDTO);
    }

}

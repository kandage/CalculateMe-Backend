package com.ains.groupit.calculateme.controller;

import com.ains.groupit.calculateme.dto.request.SteelQuantityRequestDTO;
import com.ains.groupit.calculateme.dto.response.SteelQuantityResponseDTO;
import com.ains.groupit.calculateme.service.SteelQuantityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/steel-quantity")
public class SteelQuantityController {

    @Autowired
    private SteelQuantityService steelQuantityService;

    @PostMapping("/calculate-and-save")
    public SteelQuantityResponseDTO calculateAndSaveSteelQuantity(@RequestBody SteelQuantityRequestDTO requestDTO) {
        return steelQuantityService.calculateAndSaveSteelQuantity(requestDTO);
    }
}

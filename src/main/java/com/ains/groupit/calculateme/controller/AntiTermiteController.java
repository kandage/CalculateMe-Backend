package com.ains.groupit.calculateme.controller;

import com.ains.groupit.calculateme.dto.request.AntiTermiteRequestDTO;
import com.ains.groupit.calculateme.dto.response.AntiTermiteResponseDTO;
import com.ains.groupit.calculateme.service.AntiTermiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/anti-termite-calculator")
public class AntiTermiteController {

    @Autowired
    private AntiTermiteService antiTermiteService;

    @PostMapping("/calculate")
    public AntiTermiteResponseDTO calculateAntiTermite(@RequestBody AntiTermiteRequestDTO requestDTO) {
        return antiTermiteService.calculateAndSaveAntiTermite(requestDTO);
    }
}

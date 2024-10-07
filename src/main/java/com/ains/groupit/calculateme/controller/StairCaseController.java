package com.ains.groupit.calculateme.controller;

import com.ains.groupit.calculateme.dto.request.StairCaseDTO;
import com.ains.groupit.calculateme.dto.response.StairCaseResponseDTO;
import com.ains.groupit.calculateme.service.StairCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/staircase-calculator")
public class StairCaseController {
    @Autowired
    private StairCaseService stairCaseService;

    @PostMapping("/calculate")
    public StairCaseResponseDTO calculateStairCase(@RequestBody StairCaseDTO stairCaseDTO) {
        return stairCaseService.calculateStairCase(stairCaseDTO);
    }
}

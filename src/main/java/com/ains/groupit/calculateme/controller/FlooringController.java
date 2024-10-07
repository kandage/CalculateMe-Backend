package com.ains.groupit.calculateme.controller;

import com.ains.groupit.calculateme.dto.request.FlooringRequestDTO;
import com.ains.groupit.calculateme.dto.response.FlooringResponseDTO;
import com.ains.groupit.calculateme.service.FlooringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/flooring-calculator")
public class FlooringController {

    @Autowired
    private FlooringService flooringService;

    @PostMapping("/calculate")
    public FlooringResponseDTO calculateFlooring(@RequestBody FlooringRequestDTO requestDTO) {
        return flooringService.calculateAndSaveFlooring(requestDTO);
    }
}

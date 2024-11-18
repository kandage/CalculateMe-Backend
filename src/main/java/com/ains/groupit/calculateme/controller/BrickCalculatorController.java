package com.ains.groupit.calculateme.controller;

import com.ains.groupit.calculateme.dto.request.BrickCalculationRequest;
import com.ains.groupit.calculateme.dto.response.BrickCalculationResponse;
import com.ains.groupit.calculateme.service.BrickCalculatorService;
import com.ains.groupit.calculateme.util.common.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/brick-calculator")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class BrickCalculatorController {

    private final BrickCalculatorService brickCalculatorService;

    @PostMapping("/calculate")
    public ResponseEntity<StandardResponse<BrickCalculationResponse>> calculateBricks(
            @RequestBody BrickCalculationRequest request) {

        BrickCalculationResponse responseDTO = brickCalculatorService.calculateBricks(request);

        StandardResponse<BrickCalculationResponse> response = new StandardResponse<>(
                HttpStatus.OK.value(),
                "Brick calculation successful",
                responseDTO
        );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

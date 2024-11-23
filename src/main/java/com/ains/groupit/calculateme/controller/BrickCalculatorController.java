package com.ains.groupit.calculateme.controller;

import com.ains.groupit.calculateme.dto.request.BrickCalculationRequestDTO;
import com.ains.groupit.calculateme.dto.response.BrickCalculationResponseDTO;
import com.ains.groupit.calculateme.service.BrickCalculatorService;
import com.ains.groupit.calculateme.util.common.StandardResponse;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<StandardResponse<BrickCalculationResponseDTO>> calculateBricks(
            @RequestBody BrickCalculationRequestDTO request) {

        BrickCalculationResponseDTO responseDTO = brickCalculatorService.calculateBricks(request);

        StandardResponse<BrickCalculationResponseDTO> response = new StandardResponse<>(
                HttpStatus.OK.value(),
                "Brick calculation successful",
                responseDTO
        );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

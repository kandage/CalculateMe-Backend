package com.ains.groupit.calculateme.controller;

import com.ains.groupit.calculateme.dto.request.SteelQuantityCalculationRequestDTO;
import com.ains.groupit.calculateme.dto.response.SteelQuantityCalculationResponseDTO;
import com.ains.groupit.calculateme.service.SteelQuantityService;
import com.ains.groupit.calculateme.util.common.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/steel-quantity")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class SteelQuantityCalculationController {

    private final SteelQuantityService steelQuantityService;

    @PostMapping("/calculate-and-save")
    public ResponseEntity<StandardResponse<SteelQuantityCalculationResponseDTO>> calculateAndSaveSteelQuantity(
            @RequestBody SteelQuantityCalculationRequestDTO requestDTO) {

        SteelQuantityCalculationResponseDTO responseDTO = steelQuantityService.calculateAndSaveSteelQuantity(requestDTO);

        StandardResponse<SteelQuantityCalculationResponseDTO> response = new StandardResponse<>(
                HttpStatus.OK.value(),
                "Steel quantity calculation and save successful",
                responseDTO
        );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

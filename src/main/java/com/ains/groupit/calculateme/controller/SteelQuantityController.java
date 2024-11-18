package com.ains.groupit.calculateme.controller;

import com.ains.groupit.calculateme.dto.request.SteelQuantityRequestDTO;
import com.ains.groupit.calculateme.dto.response.SteelQuantityResponseDTO;
import com.ains.groupit.calculateme.service.SteelQuantityService;
import com.ains.groupit.calculateme.util.common.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/steel-quantity")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class SteelQuantityController {

    private final SteelQuantityService steelQuantityService;

    @PostMapping("/calculate-and-save")
    public ResponseEntity<StandardResponse<SteelQuantityResponseDTO>> calculateAndSaveSteelQuantity(
            @RequestBody SteelQuantityRequestDTO requestDTO) {

        SteelQuantityResponseDTO responseDTO = steelQuantityService.calculateAndSaveSteelQuantity(requestDTO);

        StandardResponse<SteelQuantityResponseDTO> response = new StandardResponse<>(
                HttpStatus.OK.value(),
                "Steel quantity calculation and save successful",
                responseDTO
        );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

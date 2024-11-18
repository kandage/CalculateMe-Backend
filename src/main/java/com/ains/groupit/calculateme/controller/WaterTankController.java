package com.ains.groupit.calculateme.controller;

import com.ains.groupit.calculateme.dto.request.WaterTankRequestDTO;
import com.ains.groupit.calculateme.dto.response.WaterTankResponseDTO;
import com.ains.groupit.calculateme.service.WaterTankService;
import com.ains.groupit.calculateme.util.common.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/water-tank")
@CrossOrigin
@RequiredArgsConstructor
public class WaterTankController {

    private final WaterTankService waterTankService;

    @PostMapping("/calculate")
    public ResponseEntity<StandardResponse<WaterTankResponseDTO>> calculateWaterTank(@RequestBody WaterTankRequestDTO requestDTO) {
        try {
            WaterTankResponseDTO responseDTO = waterTankService.calculateWaterTank(requestDTO);
            StandardResponse<WaterTankResponseDTO> response = new StandardResponse<>(
                    HttpStatus.OK.value(),
                    "Water tank calculation successful",
                    responseDTO
            );
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new StandardResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

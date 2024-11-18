package com.ains.groupit.calculateme.controller;

import com.ains.groupit.calculateme.dto.request.StairCaseDTO;
import com.ains.groupit.calculateme.dto.response.StairCaseResponseDTO;
import com.ains.groupit.calculateme.service.StairCaseService;
import com.ains.groupit.calculateme.util.common.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/staircase-calculator")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class StairCaseController {

    private final StairCaseService stairCaseService;

    @PostMapping("/calculate")
    public ResponseEntity<StandardResponse<StairCaseResponseDTO>> calculateStairCase(
            @RequestBody StairCaseDTO stairCaseDTO) {

        StairCaseResponseDTO responseDTO = stairCaseService.calculateStairCase(stairCaseDTO);

        StandardResponse<StairCaseResponseDTO> response = new StandardResponse<>(
                HttpStatus.OK.value(),
                "Staircase calculation successful",
                responseDTO
        );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

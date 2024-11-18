package com.ains.groupit.calculateme.controller;

import com.ains.groupit.calculateme.dto.request.WoodFrameRequestDTO;
import com.ains.groupit.calculateme.dto.response.WoodFrameResponseDTO;
import com.ains.groupit.calculateme.service.WoodFrameService;
import com.ains.groupit.calculateme.util.common.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wood-frame")
@CrossOrigin
@RequiredArgsConstructor
public class WoodFrameController {

    private final WoodFrameService woodFrameService;

    @PostMapping("/calculate")
    public ResponseEntity<StandardResponse<WoodFrameResponseDTO>> calculateWoodFrame(@RequestBody WoodFrameRequestDTO requestDTO) {
        try {
            WoodFrameResponseDTO responseDTO = woodFrameService.calculateAndSaveWoodFrame(requestDTO);
            StandardResponse<WoodFrameResponseDTO> response = new StandardResponse<>(
                    HttpStatus.OK.value(),
                    "Wood frame calculation successful",
                    responseDTO
            );
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new StandardResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

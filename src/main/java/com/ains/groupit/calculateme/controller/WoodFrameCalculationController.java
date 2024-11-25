package com.ains.groupit.calculateme.controller;

import com.ains.groupit.calculateme.dto.paginatedDTO.PaginatedWaterTankCalculationDTO;
import com.ains.groupit.calculateme.dto.paginatedDTO.PaginatedWoodFrameCalculationDTO;
import com.ains.groupit.calculateme.dto.request.WoodFrameCalculationRequestDTO;
import com.ains.groupit.calculateme.dto.response.WoodFrameCalculationResponseDTO;
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
public class WoodFrameCalculationController {

    private final WoodFrameService woodFrameService;

    @PostMapping("/calculate")
    public ResponseEntity<StandardResponse<WoodFrameCalculationResponseDTO>> calculateWoodFrame(@RequestBody WoodFrameCalculationRequestDTO requestDTO) {
        try {
            WoodFrameCalculationResponseDTO responseDTO = woodFrameService.calculateAndSaveWoodFrame(requestDTO);
            StandardResponse<WoodFrameCalculationResponseDTO> response = new StandardResponse<>(
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

    @GetMapping("/all")
    public ResponseEntity<StandardResponse> getAllPaginated(
            @RequestParam(value = "searchText", required = false) String searchText,
            @RequestParam int pageNo,
            @RequestParam int size) {
        PaginatedWoodFrameCalculationDTO woodFrameDetails = woodFrameService.getAllPaginatedWoodFrameDetails(searchText, pageNo, size);

        return new ResponseEntity<>(
                new StandardResponse(200, "success", woodFrameDetails),
                HttpStatus.OK
        );
    }
}

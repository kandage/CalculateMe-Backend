package com.ains.groupit.calculateme.controller;

import com.ains.groupit.calculateme.dto.paginatedDTO.PaginatedWaterTankCalculationDTO;
import com.ains.groupit.calculateme.dto.request.WaterTankCalculationRequestDTO;
import com.ains.groupit.calculateme.dto.response.WaterTankCalculationResponseDTO;
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
public class WaterTankCalculationController {

    private final WaterTankService waterTankService;

    @PostMapping("/calculate")
    public ResponseEntity<StandardResponse<WaterTankCalculationResponseDTO>> calculateWaterTank(@RequestBody WaterTankCalculationRequestDTO requestDTO) {
        try {
            WaterTankCalculationResponseDTO responseDTO = waterTankService.calculateWaterTank(requestDTO);
            StandardResponse<WaterTankCalculationResponseDTO> response = new StandardResponse<>(
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

    @GetMapping("/all")
    public ResponseEntity<StandardResponse> getAllPaginated(
            @RequestParam int pageNo,
            @RequestParam int size) {
        PaginatedWaterTankCalculationDTO steelQuantityDetails = waterTankService.getAllPaginatedWaterTankDetails(pageNo, size);

        return new ResponseEntity<>(
                new StandardResponse(200, "success", steelQuantityDetails),
                HttpStatus.OK
        );
    }
}

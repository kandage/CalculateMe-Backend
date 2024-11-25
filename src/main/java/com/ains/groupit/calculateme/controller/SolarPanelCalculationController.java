package com.ains.groupit.calculateme.controller;

import com.ains.groupit.calculateme.dto.paginatedDTO.PaginatedSolarPanelCalculationDTO;
import com.ains.groupit.calculateme.dto.request.SolarPanelCalculationRequestDTO;
import com.ains.groupit.calculateme.dto.response.SolarPanelCalculationResponseDTO;
import com.ains.groupit.calculateme.service.SolarPanelService;
import com.ains.groupit.calculateme.util.common.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/solar-calculator")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class SolarPanelCalculationController {

    private final SolarPanelService solarPanelService;

    @PostMapping("/calculate")
    public ResponseEntity<StandardResponse<SolarPanelCalculationResponseDTO>> calculateSolarPanels(
            @RequestBody SolarPanelCalculationRequestDTO calculationDTO) {

        SolarPanelCalculationResponseDTO solarPanelDetail = solarPanelService.calculate(calculationDTO);

        StandardResponse<SolarPanelCalculationResponseDTO> response = new StandardResponse<>(
                HttpStatus.OK.value(),
                "Solar panel calculation successful",
                solarPanelDetail
        );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<StandardResponse> getAllPaginated(
            @RequestParam int pageNo,
            @RequestParam int size) {
        PaginatedSolarPanelCalculationDTO solarPanelDTO = solarPanelService.getAllPaginatedSolarPanelDetails(pageNo, size);

        return new ResponseEntity<>(
                new StandardResponse(200, "success", solarPanelDTO),
                HttpStatus.OK
        );
    }
}

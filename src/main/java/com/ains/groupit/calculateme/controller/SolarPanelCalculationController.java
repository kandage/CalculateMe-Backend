package com.ains.groupit.calculateme.controller;

import com.ains.groupit.calculateme.dto.paginatedDTO.PaginatedSolarPanelDTO;
import com.ains.groupit.calculateme.dto.request.SolarPanelCalculationRequestDTO;
import com.ains.groupit.calculateme.dto.response.SolarPanelResponseDTO;
import com.ains.groupit.calculateme.entity.SolarPanelDetail;
import com.ains.groupit.calculateme.service.SolarPanelCalculationService;
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

    private final SolarPanelCalculationService solarPanelCalculationService;

    @PostMapping("/calculate")
    public ResponseEntity<StandardResponse<SolarPanelResponseDTO>> calculateSolarPanels(
            @RequestBody SolarPanelCalculationRequestDTO calculationDTO) {

        SolarPanelResponseDTO solarPanelDetail = solarPanelCalculationService.calculate(calculationDTO);

        StandardResponse<SolarPanelResponseDTO> response = new StandardResponse<>(
                HttpStatus.OK.value(),
                "Solar panel calculation successful",
                solarPanelDetail
        );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<StandardResponse> getAllPaginated(
            @RequestParam(value = "searchText", required = false) String searchText,
            @RequestParam int pageNo,
            @RequestParam int size) {
        PaginatedSolarPanelDTO solarPanelDTO = solarPanelCalculationService.getAllPaginatedSolarPanelDetails(searchText, pageNo, size);

        return new ResponseEntity<>(
                new StandardResponse(200, "success", solarPanelDTO),
                HttpStatus.OK
        );
    }
}

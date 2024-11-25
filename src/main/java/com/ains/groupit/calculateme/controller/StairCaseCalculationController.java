package com.ains.groupit.calculateme.controller;

import com.ains.groupit.calculateme.dto.paginatedDTO.PaginatedStairCaseCalculationDTO;
import com.ains.groupit.calculateme.dto.request.StairCaseCalculationRequestDTO;
import com.ains.groupit.calculateme.dto.response.StairCaseCalculationResponseDTO;
import com.ains.groupit.calculateme.service.StairCaseService;
import com.ains.groupit.calculateme.util.common.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/staircase-calculator")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class StairCaseCalculationController {

    private final StairCaseService stairCaseService;

    @PostMapping("/calculate")
    public ResponseEntity<StandardResponse<StairCaseCalculationResponseDTO>> calculateStairCase(
            @RequestBody StairCaseCalculationRequestDTO stairCaseDTO) {

        StairCaseCalculationResponseDTO responseDTO = stairCaseService.calculateStairCase(stairCaseDTO);

        StandardResponse<StairCaseCalculationResponseDTO> response = new StandardResponse<>(
                HttpStatus.OK.value(),
                "Staircase calculation successful",
                responseDTO
        );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<StandardResponse> getAllPaginated(
            @RequestParam int pageNo,
            @RequestParam int size) {
        PaginatedStairCaseCalculationDTO stairCaseCalculationDTO = stairCaseService.getAllPaginatedStairCaseDetails(pageNo, size);

        return new ResponseEntity<>(
                new StandardResponse(200, "success", stairCaseCalculationDTO),
                HttpStatus.OK
        );
    }
}

package com.ains.groupit.calculateme.controller;

import com.ains.groupit.calculateme.dto.paginatedDTO.PaginatedAntiTermiteCalculationDTO;
import com.ains.groupit.calculateme.dto.request.AntiTermiteCalculationRequestDTO;
import com.ains.groupit.calculateme.dto.response.AntiTermiteCalculationResponseDTO;
import com.ains.groupit.calculateme.service.AntiTermiteService;
import com.ains.groupit.calculateme.util.common.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/anti-termite-calculator")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AntiTermiteCalculationController {

    private final AntiTermiteService antiTermiteService;

    @PostMapping("/calculate")
    public ResponseEntity<StandardResponse<AntiTermiteCalculationResponseDTO>> calculateAntiTermite(
            @RequestBody AntiTermiteCalculationRequestDTO requestDTO) {

        AntiTermiteCalculationResponseDTO responseDTO = antiTermiteService.calculateAndSaveAntiTermite(requestDTO);

        StandardResponse<AntiTermiteCalculationResponseDTO> response = new StandardResponse<>(
                HttpStatus.OK.value(),
                "Anti-termite calculation successful",
                responseDTO
        );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<StandardResponse> getAllPaginated(
            @RequestParam(value = "searchText", required = false) String searchText,
            @RequestParam int pageNo,
            @RequestParam int size) {
        PaginatedAntiTermiteCalculationDTO antiTermiteDTO = antiTermiteService.getAllAntiTermites(searchText, pageNo, size);

        return new ResponseEntity<>(
                new StandardResponse(200, "success", antiTermiteDTO),
                HttpStatus.OK
        );
    }
}

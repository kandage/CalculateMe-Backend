package com.ains.groupit.calculateme.controller;

import com.ains.groupit.calculateme.dto.paginatedDTO.PaginatedFlooringCalculationDTO;
import com.ains.groupit.calculateme.dto.request.FlooringCalculationRequestDTO;
import com.ains.groupit.calculateme.dto.response.FlooringCalculationResponseDTO;
import com.ains.groupit.calculateme.service.FlooringService;
import com.ains.groupit.calculateme.util.common.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flooring-calculator")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class FlooringCalculationController {

    private final FlooringService flooringService;

    @PostMapping("/calculate")
    public ResponseEntity<StandardResponse<FlooringCalculationResponseDTO>> calculateFlooring(
            @RequestBody FlooringCalculationRequestDTO requestDTO) {

        FlooringCalculationResponseDTO responseDTO = flooringService.calculateAndSaveFlooring(requestDTO);

        StandardResponse<FlooringCalculationResponseDTO> response = new StandardResponse<>(
                HttpStatus.OK.value(),
                "Flooring calculation successful",
                responseDTO
        );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<StandardResponse> getAllPaginated(
            @RequestParam(value = "searchText", required = false) String searchText,
            @RequestParam int pageNo,
            @RequestParam int size) {
        PaginatedFlooringCalculationDTO flooringDetails = flooringService.getAllPaginatedFlooringDetails(searchText, pageNo, size);

        return new ResponseEntity<>(
                new StandardResponse(200, "success", flooringDetails),
                HttpStatus.OK
        );
    }
}

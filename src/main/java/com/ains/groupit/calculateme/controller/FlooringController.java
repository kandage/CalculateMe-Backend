package com.ains.groupit.calculateme.controller;

import com.ains.groupit.calculateme.dto.paginatedDTO.PaginatedBrickCalculatorDTO;
import com.ains.groupit.calculateme.dto.paginatedDTO.PaginatedFlooringDTO;
import com.ains.groupit.calculateme.dto.request.FlooringRequestDTO;
import com.ains.groupit.calculateme.dto.response.FlooringResponseDTO;
import com.ains.groupit.calculateme.service.FlooringService;
import com.ains.groupit.calculateme.util.common.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flooring-calculator")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class FlooringController {

    private final FlooringService flooringService;

    @PostMapping("/calculate")
    public ResponseEntity<StandardResponse<FlooringResponseDTO>> calculateFlooring(
            @RequestBody FlooringRequestDTO requestDTO) {

        FlooringResponseDTO responseDTO = flooringService.calculateAndSaveFlooring(requestDTO);

        StandardResponse<FlooringResponseDTO> response = new StandardResponse<>(
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
        PaginatedFlooringDTO flooringDetails = flooringService.getAllPaginatedFlooringDetails(searchText, pageNo, size);

        return new ResponseEntity<>(
                new StandardResponse(200, "success", flooringDetails),
                HttpStatus.OK
        );
    }
}

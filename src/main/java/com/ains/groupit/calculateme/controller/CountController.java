package com.ains.groupit.calculateme.controller;

import com.ains.groupit.calculateme.dto.paginatedDTO.PaginatedFlooringCalculationDTO;
import com.ains.groupit.calculateme.dto.response.AllCountResponseDTO;
import com.ains.groupit.calculateme.service.AllCountService;
import com.ains.groupit.calculateme.service.SolarPanelService;
import com.ains.groupit.calculateme.util.common.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/count")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class CountController {
    private final AllCountService allCountService;
    @GetMapping("/all")
    public ResponseEntity<StandardResponse> getAllCount() {
        AllCountResponseDTO allCount = allCountService.getAllCount();

        return new ResponseEntity<>(
                new StandardResponse(200, "success", allCount),
                HttpStatus.OK
        );
    }
}

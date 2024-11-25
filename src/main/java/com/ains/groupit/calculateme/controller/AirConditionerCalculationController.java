package com.ains.groupit.calculateme.controller;

import com.ains.groupit.calculateme.dto.paginatedDTO.PaginatedAirConditionerCalculationDTO;
import com.ains.groupit.calculateme.dto.request.AirConditionerCalculationRequestDTO;
import com.ains.groupit.calculateme.entity.AirConditionerDetail;
import com.ains.groupit.calculateme.service.AirConditionerService;
import com.ains.groupit.calculateme.util.common.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/air-conditioner")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AirConditionerCalculationController {

    private final AirConditionerService airConditionerService;

    @PostMapping("/calculate")
    public ResponseEntity<StandardResponse<AirConditionerDetail>> calculateACSize(@RequestBody AirConditionerCalculationRequestDTO airConditionerCalculationRequestDTO) {
        AirConditionerDetail savedAirConditionerDetail = airConditionerService.saveRoomDetails(airConditionerCalculationRequestDTO);
        StandardResponse<AirConditionerDetail> response = new StandardResponse<>(
                HttpStatus.OK.value(),
                "AC size calculated and data saved successfully",
                savedAirConditionerDetail
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<StandardResponse> getAllPaginated(
            @RequestParam int pageNo,
            @RequestParam int size) {
        PaginatedAirConditionerCalculationDTO airConditionerDTO = airConditionerService.getAllAirConditioners(pageNo, size);

        return new ResponseEntity<>(
                new StandardResponse(200, "success", airConditionerDTO),
                HttpStatus.OK
        );
    }

}

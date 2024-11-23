package com.ains.groupit.calculateme.controller;

import com.ains.groupit.calculateme.dto.paginatedDTO.PaginatedAirConditionerDTO;
import com.ains.groupit.calculateme.dto.request.AirConditionerRequestDTO;
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
public class AirConditionerController {

    private final AirConditionerService airConditionerService;

    @PostMapping("/calculate")
    public ResponseEntity<StandardResponse<AirConditionerDetail>> calculateACSize(@RequestBody AirConditionerRequestDTO airConditionerRequestDTO) {
        AirConditionerDetail savedAirConditionerDetail = airConditionerService.saveRoomDetails(airConditionerRequestDTO);
        StandardResponse<AirConditionerDetail> response = new StandardResponse<>(
                HttpStatus.OK.value(),
                "AC size calculated and data saved successfully",
                savedAirConditionerDetail
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<StandardResponse> getAllPaginated(
            @RequestParam(value = "searchText", required = false) String searchText,
            @RequestParam int pageNo,
            @RequestParam int size) {
        PaginatedAirConditionerDTO airConditionerDTO = airConditionerService.getAllAirConditioners(searchText, pageNo, size);

        return new ResponseEntity<>(
                new StandardResponse(200, "success", airConditionerDTO),
                HttpStatus.OK
        );
    }

}

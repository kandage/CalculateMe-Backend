package com.ains.groupit.calculateme.controller;

import com.ains.groupit.calculateme.entity.RoomDetails;
import com.ains.groupit.calculateme.service.AirConditionerService;
import com.ains.groupit.calculateme.util.common.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<StandardResponse<String>> calculateACSize(@RequestBody RoomDetails roomDetails) {
        double acSize = airConditionerService.calculateACSize(roomDetails);
        String acSizeMessage = acSize + " Tons";
        StandardResponse<String> response = new StandardResponse<>(
                HttpStatus.OK.value(),
                "AC size calculated successfully",
                acSizeMessage
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

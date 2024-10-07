package com.ains.groupit.calculateme.controller;

import com.ains.groupit.calculateme.entity.RoomDetails;
import com.ains.groupit.calculateme.service.AirConditionerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/airconditioner")
public class AirConditionerController {
    @Autowired
    private AirConditionerService airConditionerService;

    /**
     * Endpoint to calculate AC size based on room details.
     * @param roomDetails - the room details provided in the request body
     * @return the calculated AC size
     */
    @PostMapping("/calculate")
    public String calculateACSize(@RequestBody RoomDetails roomDetails) {
        double acSize = airConditionerService.calculateACSize(roomDetails);
        return acSize + " Tons";
    }
}

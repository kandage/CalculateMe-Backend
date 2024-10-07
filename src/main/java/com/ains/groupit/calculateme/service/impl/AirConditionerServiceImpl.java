package com.ains.groupit.calculateme.service.impl;

import com.ains.groupit.calculateme.entity.RoomDetails;
import com.ains.groupit.calculateme.service.AirConditionerService;
import org.springframework.stereotype.Service;

@Service
public class AirConditionerServiceImpl implements AirConditionerService {
    @Override
    public double calculateACSize(RoomDetails roomDetails) {
        double length = roomDetails.getLength();
        double breadth = roomDetails.getBreadth();
        double height = roomDetails.getHeight();
        int personCount = roomDetails.getPersonCount();
        double maximumTemp = roomDetails.getMaxTemperature();

        double noOfPerson;
        double temperature;
        double heightEquation;

        if (personCount <= 3) {
            noOfPerson = 0.3;
        } else {
            noOfPerson = 0.3 + (personCount - 3) * 0.07;
        }

        if (maximumTemp > 45) {
            temperature = 0.5;
        } else if (maximumTemp > 40 && maximumTemp <= 45) {
            temperature = 0.4;
        } else if (maximumTemp > 35 && maximumTemp <= 40) {
            temperature = 0.3;
        } else {
            temperature = 0.2;
        }

        if (height <= 8.0) {
            heightEquation = 0.0;
        } else {
            heightEquation = (height - 8.0) * 0.1;
        }

        return Math.round((((length * breadth * 20) / 12000) + noOfPerson + temperature + heightEquation) * 100.0) / 100.0;
    }
}

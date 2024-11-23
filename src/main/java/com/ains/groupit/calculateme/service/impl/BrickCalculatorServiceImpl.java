package com.ains.groupit.calculateme.service.impl;

import com.ains.groupit.calculateme.dto.request.BrickCalculationRequestDTO;
import com.ains.groupit.calculateme.dto.response.BrickCalculationResponseDTO;
import com.ains.groupit.calculateme.service.BrickCalculatorService;
import org.springframework.stereotype.Service;

@Service
public class BrickCalculatorServiceImpl implements BrickCalculatorService {

    @Override
    public BrickCalculationResponseDTO calculateBricks(BrickCalculationRequestDTO request) {
        double wallLength = request.getWallLength();
        double wallHeight = request.getWallHeight();
        double wallThickness = request.getWallThickness().equals("10cm wall") ? 0.10 : 0.23;

        double brickLength = request.getBrickLength();
        double brickWidth = request.getBrickWidth();
        double brickHeight = request.getBrickHeight();

        double brickMasonry = wallLength * wallHeight * wallThickness;
        double brickVolume = (brickLength + 0.01) * (brickWidth + 0.01) * (brickHeight + 0.01);

        int noOfBricks = (int) Math.ceil(brickMasonry / brickVolume);

        double bricksMortar = noOfBricks * (brickLength * brickWidth * brickHeight);
        double tempMortar = brickMasonry - bricksMortar;
        double tempMortar2 = tempMortar + (tempMortar * 0.15);
        double mortarQuantity = tempMortar2 + (tempMortar2 * 0.25);

        double cement, sand, tempSandQuantity, sandQuantity;
        String ratio = request.getCementRatio();

        switch (ratio) {
            case "C.M 1:3":
                cement = mortarQuantity / 4.0;
                sand = mortarQuantity * (3 / 4.0);
                break;
            case "C.M 1:4":
                cement = mortarQuantity / 5.0;
                sand = mortarQuantity * (4 / 5.0);
                break;
            case "C.M 1:5":
                cement = mortarQuantity / 6.0;
                sand = mortarQuantity * (5 / 6.0);
                break;
            case "C.M 1:6":
                cement = mortarQuantity / 7.0;
                sand = mortarQuantity * (6 / 7.0);
                break;
            case "C.M 1:7":
                cement = mortarQuantity / 8.0;
                sand = mortarQuantity * (7 / 8.0);
                break;
            case "C.M 1:8":
                cement = mortarQuantity / 9.0;
                sand = mortarQuantity * (8 / 9.0);
                break;
            case "C.M 1:9":
                cement = mortarQuantity / 10.0;
                sand = mortarQuantity * (9 / 10.0);
                break;
            default:
                cement = mortarQuantity;
                sand = mortarQuantity;
                break;
        }

        int cementBags = (int) Math.ceil(cement / 0.035);
        tempSandQuantity = sand * 1500;
        sandQuantity = Math.round((tempSandQuantity) / 1000 * 100.0) / 100.0;

        BrickCalculationResponseDTO response = new BrickCalculationResponseDTO();
        response.setNumberOfBricks(noOfBricks);
        response.setCementBags(cementBags);
        response.setSandQuantity(sandQuantity);

        return response;
    }
}

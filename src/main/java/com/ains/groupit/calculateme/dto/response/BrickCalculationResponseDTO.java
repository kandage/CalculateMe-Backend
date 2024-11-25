package com.ains.groupit.calculateme.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrickCalculationResponseDTO {
    private double wallLength;
    private double wallHeight;
    private double wallThickness;

    private double brickLength;
    private double brickWidth;
    private double brickHeight;

    private String cementRatio;

    private int numberOfBricks;
    private int cementBags;
    private double sandQuantity;
}

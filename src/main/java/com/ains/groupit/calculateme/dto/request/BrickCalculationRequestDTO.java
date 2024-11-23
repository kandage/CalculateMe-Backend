package com.ains.groupit.calculateme.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrickCalculationRequestDTO {
    private double wallLength;
    private double wallHeight;
    private String wallThickness;
    private double brickLength;
    private double brickWidth;
    private double brickHeight;
    private String cementRatio;
}

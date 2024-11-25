package com.ains.groupit.calculateme.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StairCaseCalculationResponseDTO {
    private double riser;
    private double tread;
    private double stairWidth;
    private double stairHeight;
    private double slabThickness;
    private String grade;

    private double totalVolumeOfStair;
    private double cementBags;
    private double sandInTons;
    private double aggregateInTons;
}

package com.ains.groupit.calculateme.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StairCaseCalculationRequestDTO {
    private double riser;
    private double tread;
    private double stairWidth;
    private double stairHeight;
    private double slabThickness;
    private String grade;
}

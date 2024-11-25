package com.ains.groupit.calculateme.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SolarPanelResponseDTO {
    private double units;
    private String consumptionType;
    private double dailyConsumption;
    private double rooftopCapacity;
    private int panelCount;
    private double areaRequired;
}

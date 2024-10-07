package com.ains.groupit.calculateme.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SolarPanelCalculationDTO {
    private double units;
    private String consumptionType;
}

package com.ains.groupit.calculateme.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SolarPanelCalculationRequestDTO {
    private double units;
    private String consumptionType;
}

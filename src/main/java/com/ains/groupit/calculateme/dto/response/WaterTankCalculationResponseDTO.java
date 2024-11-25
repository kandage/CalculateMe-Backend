package com.ains.groupit.calculateme.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WaterTankCalculationResponseDTO {
    private double length;
    private double width;
    private double depth;

    private double volume;
    private double capacity;
}

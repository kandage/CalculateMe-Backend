package com.ains.groupit.calculateme.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WaterTankCalculationRequestDTO {
    private double length;
    private double width;
    private double depth;
}

package com.ains.groupit.calculateme.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlooringCalculationRequestDTO {
    private double floorLength;
    private double floorWidth;
    private double tileLength;
    private double tileWidth;
}

package com.ains.groupit.calculateme.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlooringCalculationResponseDTO {
    private double floorLength;
    private double floorWidth;
    private double tileLength;
    private double tileWidth;
    private int numberOfTiles;
    private int cementBags;
    private double sandQuantity;
}

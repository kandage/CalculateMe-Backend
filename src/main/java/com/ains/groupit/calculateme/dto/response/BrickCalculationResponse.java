package com.ains.groupit.calculateme.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrickCalculationResponse {
    private int numberOfBricks;
    private int cementBags;
    private double sandQuantity;
}

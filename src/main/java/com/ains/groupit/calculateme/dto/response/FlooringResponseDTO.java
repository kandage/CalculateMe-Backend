package com.ains.groupit.calculateme.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlooringResponseDTO {
    private int numberOfTiles;
    private int cementBags;
    private double sandQuantity;
    private String message;
}
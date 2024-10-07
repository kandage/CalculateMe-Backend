package com.ains.groupit.calculateme.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StairCaseResponseDTO {
    private double totalVolumeOfStair;
    private double cementBags;
    private double sandInTons;
    private double aggregateInTons;
}

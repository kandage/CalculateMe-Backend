package com.ains.groupit.calculateme.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SteelQuantityResponseDTO {
    private String memberType;
    private double concreteQuantity;
    private double steelWeight;
}

package com.ains.groupit.calculateme.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SteelQuantityCalculationRequestDTO {
    private String mType;
    private double concreteQuantity;
}

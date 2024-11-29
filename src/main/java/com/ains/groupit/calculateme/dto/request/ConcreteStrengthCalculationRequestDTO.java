package com.ains.groupit.calculateme.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConcreteStrengthCalculationRequestDTO {
    private Double ash;
    private Double water;
    private Double superplasticizer;
    private Double coarseAggregate;
    private Double fineAggregate;
    private Double cement;
    private Double age;
    private Double slag;
}

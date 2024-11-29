package com.ains.groupit.calculateme.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WoodFrameCalculationResponseDTO {
    private double length;
    private double width;
    private double thickness;
    private double volume;
}
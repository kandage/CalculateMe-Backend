package com.ains.groupit.calculateme.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirConditionerRequestDTO {
    private double length;
    private double breadth;
    private double height;
    private int personCount;
    private double maxTemp;
}

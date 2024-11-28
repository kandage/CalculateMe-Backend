package com.ains.groupit.calculateme.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AllCountResponseDTO {
    private long airConditionerDetailCount;
    private long antiTermiteDetailCount;
    private long brickCalculationDetailCount;
    private long flooringDetailCount;
    private long solarPanelDetailCount;
    private long stairCaseDetailCount;
    private long steelQuantityDetailCount;
    private long waterTankDetailCount;
    private long woodFrameDetailCount;
}

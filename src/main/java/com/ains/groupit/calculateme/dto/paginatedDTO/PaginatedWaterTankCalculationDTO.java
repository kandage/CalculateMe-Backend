package com.ains.groupit.calculateme.dto.paginatedDTO;

import com.ains.groupit.calculateme.entity.WaterTankDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedWaterTankCalculationDTO {
    private List<WaterTankDetail> waterTankDetails;
    private long totalElements;
    private int totalPages;
    private int currentPage;
}

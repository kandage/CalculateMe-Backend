package com.ains.groupit.calculateme.dto.paginatedDTO;

import com.ains.groupit.calculateme.entity.WaterTankDetail;
import com.ains.groupit.calculateme.entity.WoodFrameDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedWoodFrameCalculationDTO {
    private List<WoodFrameDetail> woodFrameDetails;
    private long totalElements;
    private int totalPages;
    private int currentPage;
}

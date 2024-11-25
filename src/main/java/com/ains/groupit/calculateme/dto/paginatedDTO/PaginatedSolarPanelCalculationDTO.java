package com.ains.groupit.calculateme.dto.paginatedDTO;

import com.ains.groupit.calculateme.entity.SolarPanelDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedSolarPanelCalculationDTO {
    private List<SolarPanelDetail> solarPanelDetails;
    private long totalElements;
    private int totalPages;
    private int currentPage;
}

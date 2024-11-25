package com.ains.groupit.calculateme.dto.paginatedDTO;

import com.ains.groupit.calculateme.entity.StairCaseDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedStairCaseCalculationDTO {
    private List<StairCaseDetail> stairCaseDetails;
    private long totalElements;
    private int totalPages;
    private int currentPage;
}

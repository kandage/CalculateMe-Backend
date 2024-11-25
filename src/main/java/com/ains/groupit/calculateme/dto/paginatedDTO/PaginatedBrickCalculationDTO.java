package com.ains.groupit.calculateme.dto.paginatedDTO;

import com.ains.groupit.calculateme.entity.BrickCalculationDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedBrickCalculationDTO {
    private List<BrickCalculationDetail> brickCalculationDetails;
    private long totalElements;
    private int totalPages;
    private int currentPage;
}

package com.ains.groupit.calculateme.dto.paginatedDTO;

import com.ains.groupit.calculateme.entity.SteelQuantityDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedSteelQuantityCalculationDTO {
    private List<SteelQuantityDetails> steelQuantityDetails;
    private long totalElements;
    private int totalPages;
    private int currentPage;
}

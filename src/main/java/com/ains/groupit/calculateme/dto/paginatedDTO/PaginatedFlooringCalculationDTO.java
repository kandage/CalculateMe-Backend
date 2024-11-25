package com.ains.groupit.calculateme.dto.paginatedDTO;

import com.ains.groupit.calculateme.entity.FlooringDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedFlooringCalculationDTO {
    private List<FlooringDetail> flooringDetails;
    private long totalElements;
    private int totalPages;
    private int currentPage;
}

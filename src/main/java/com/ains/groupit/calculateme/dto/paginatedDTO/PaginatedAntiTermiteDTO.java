package com.ains.groupit.calculateme.dto.paginatedDTO;

import com.ains.groupit.calculateme.entity.AntiTermiteDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedAntiTermiteDTO {
    private List<AntiTermiteDetail> antiTermiteDetails;
    private long totalElements;
    private int totalPages;
    private int currentPage;
}

package com.ains.groupit.calculateme.dto.paginatedDTO;

import com.ains.groupit.calculateme.entity.AirConditionerDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedAirConditionerDTO {
    private List<AirConditionerDetail> airConditioners;
    private long totalElements;
    private int totalPages;
    private int currentPage;
}


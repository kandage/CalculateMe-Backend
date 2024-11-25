package com.ains.groupit.calculateme.service;

import com.ains.groupit.calculateme.dto.paginatedDTO.PaginatedWaterTankCalculationDTO;
import com.ains.groupit.calculateme.dto.request.WaterTankCalculationRequestDTO;
import com.ains.groupit.calculateme.dto.response.WaterTankCalculationResponseDTO;

public interface WaterTankService {
    WaterTankCalculationResponseDTO calculateWaterTank(WaterTankCalculationRequestDTO requestDTO);

    PaginatedWaterTankCalculationDTO getAllPaginatedWaterTankDetails(String searchText, int pageNo, int size);
}

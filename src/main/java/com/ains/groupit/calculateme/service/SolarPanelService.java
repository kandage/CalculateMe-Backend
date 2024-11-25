package com.ains.groupit.calculateme.service;

import com.ains.groupit.calculateme.dto.paginatedDTO.PaginatedSolarPanelCalculationDTO;
import com.ains.groupit.calculateme.dto.request.SolarPanelCalculationRequestDTO;
import com.ains.groupit.calculateme.dto.response.SolarPanelCalculationResponseDTO;

public interface SolarPanelService {
    SolarPanelCalculationResponseDTO calculate(SolarPanelCalculationRequestDTO calculationDTO);

    PaginatedSolarPanelCalculationDTO getAllPaginatedSolarPanelDetails(String searchText, int pageNo, int size);
}

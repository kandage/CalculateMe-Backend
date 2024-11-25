package com.ains.groupit.calculateme.service;

import com.ains.groupit.calculateme.dto.paginatedDTO.PaginatedSolarPanelDTO;
import com.ains.groupit.calculateme.dto.request.SolarPanelCalculationRequestDTO;
import com.ains.groupit.calculateme.dto.response.SolarPanelResponseDTO;

public interface SolarPanelCalculationService {
    SolarPanelResponseDTO calculate(SolarPanelCalculationRequestDTO calculationDTO);

    PaginatedSolarPanelDTO getAllPaginatedSolarPanelDetails(String searchText, int pageNo, int size);
}

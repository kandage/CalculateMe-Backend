package com.ains.groupit.calculateme.service;

import com.ains.groupit.calculateme.dto.paginatedDTO.PaginatedWoodFrameCalculationDTO;
import com.ains.groupit.calculateme.dto.request.WoodFrameCalculationRequestDTO;
import com.ains.groupit.calculateme.dto.response.WoodFrameCalculationResponseDTO;

import java.io.ByteArrayInputStream;

public interface WoodFrameService {
    WoodFrameCalculationResponseDTO calculateAndSaveWoodFrame(WoodFrameCalculationRequestDTO requestDTO);

    PaginatedWoodFrameCalculationDTO getAllPaginatedWoodFrameDetails(int pageNo, int size);

    ByteArrayInputStream downloadCsv();
}

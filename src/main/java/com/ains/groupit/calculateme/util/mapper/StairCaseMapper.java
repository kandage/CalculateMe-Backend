package com.ains.groupit.calculateme.util.mapper;

import com.ains.groupit.calculateme.dto.request.StairCaseCalculationRequestDTO;
import com.ains.groupit.calculateme.dto.response.StairCaseCalculationResponseDTO;
import com.ains.groupit.calculateme.entity.StairCaseDetail;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StairCaseMapper {
    StairCaseDetail toEntity(StairCaseCalculationRequestDTO dto);

    StairCaseCalculationResponseDTO toResponseDTO(StairCaseDetail entity);
}

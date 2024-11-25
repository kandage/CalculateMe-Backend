package com.ains.groupit.calculateme.util.mapper;

import com.ains.groupit.calculateme.dto.request.BrickCalculationRequestDTO;
import com.ains.groupit.calculateme.dto.response.BrickCalculationResponseDTO;
import com.ains.groupit.calculateme.entity.BrickCalculationDetail;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrickCalculationMapper {

    BrickCalculationDetail toEntity(BrickCalculationRequestDTO dto);

    BrickCalculationResponseDTO toResponseDTO(BrickCalculationDetail entity);
}

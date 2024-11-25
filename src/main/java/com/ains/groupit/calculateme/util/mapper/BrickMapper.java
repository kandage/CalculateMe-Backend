package com.ains.groupit.calculateme.util.mapper;

import com.ains.groupit.calculateme.dto.request.BrickCalculationCalculationRequestDTO;
import com.ains.groupit.calculateme.dto.response.BrickCalculationResponseDTO;
import com.ains.groupit.calculateme.entity.BrickCalculationDetail;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrickMapper {

    BrickCalculationDetail toEntity(BrickCalculationCalculationRequestDTO dto);

    BrickCalculationResponseDTO toResponseDTO(BrickCalculationDetail entity);
}

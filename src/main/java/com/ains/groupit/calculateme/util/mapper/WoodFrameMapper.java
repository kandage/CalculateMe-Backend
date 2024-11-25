package com.ains.groupit.calculateme.util.mapper;

import com.ains.groupit.calculateme.dto.request.WoodFrameCalculationRequestDTO;
import com.ains.groupit.calculateme.dto.response.WoodFrameCalculationResponseDTO;
import com.ains.groupit.calculateme.entity.WoodFrameDetail;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WoodFrameMapper {
    WoodFrameDetail toEntity(WoodFrameCalculationRequestDTO dto);

    WoodFrameCalculationResponseDTO toResponseDTO(WoodFrameDetail entity);
}

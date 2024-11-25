package com.ains.groupit.calculateme.util.mapper;

import com.ains.groupit.calculateme.dto.request.WaterTankCalculationRequestDTO;
import com.ains.groupit.calculateme.dto.response.WaterTankCalculationResponseDTO;
import com.ains.groupit.calculateme.entity.WaterTankDetail;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WaterTankMapper {
    WaterTankDetail toEntity(WaterTankCalculationRequestDTO dto);

    WaterTankCalculationResponseDTO toResponseDTO(WaterTankDetail entity);
}

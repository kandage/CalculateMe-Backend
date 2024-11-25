package com.ains.groupit.calculateme.util.mapper;

import com.ains.groupit.calculateme.dto.request.SolarPanelCalculationRequestDTO;
import com.ains.groupit.calculateme.dto.response.SolarPanelCalculationResponseDTO;
import com.ains.groupit.calculateme.entity.SolarPanelDetail;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SolarPanelMapper {
    SolarPanelDetail toEntity(SolarPanelCalculationRequestDTO dto);

    SolarPanelCalculationResponseDTO toResponseDTO(SolarPanelDetail entity);
}

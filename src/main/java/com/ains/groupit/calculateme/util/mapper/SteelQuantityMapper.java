package com.ains.groupit.calculateme.util.mapper;

import com.ains.groupit.calculateme.dto.request.SteelQuantityCalculationRequestDTO;
import com.ains.groupit.calculateme.dto.response.SteelQuantityCalculationResponseDTO;
import com.ains.groupit.calculateme.entity.SteelQuantityDetails;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SteelQuantityMapper {
    SteelQuantityDetails toEntity(SteelQuantityCalculationRequestDTO dto);

    SteelQuantityCalculationResponseDTO toResponseDTO(SteelQuantityDetails entity);
}

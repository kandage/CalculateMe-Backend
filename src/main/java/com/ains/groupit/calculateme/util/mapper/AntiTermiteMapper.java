package com.ains.groupit.calculateme.util.mapper;

import com.ains.groupit.calculateme.dto.request.AntiTermiteCalculationRequestDTO;
import com.ains.groupit.calculateme.dto.response.AntiTermiteCalculationResponseDTO;
import com.ains.groupit.calculateme.entity.AntiTermiteDetail;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AntiTermiteMapper {
    AntiTermiteDetail toEntity(AntiTermiteCalculationRequestDTO dto);

    AntiTermiteCalculationResponseDTO toResponseDTO(AntiTermiteDetail entity);
}

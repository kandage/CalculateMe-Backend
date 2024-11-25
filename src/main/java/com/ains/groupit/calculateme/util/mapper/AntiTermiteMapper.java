package com.ains.groupit.calculateme.util.mapper;

import com.ains.groupit.calculateme.dto.request.AntiTermiteRequestDTO;
import com.ains.groupit.calculateme.dto.response.AntiTermiteResponseDTO;
import com.ains.groupit.calculateme.entity.AntiTermiteDetail;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AntiTermiteMapper {
    AntiTermiteDetail toEntity(AntiTermiteRequestDTO dto);

    AntiTermiteResponseDTO toResponseDTO(AntiTermiteDetail entity);
}

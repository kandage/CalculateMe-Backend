package com.ains.groupit.calculateme.util.mapper;

import com.ains.groupit.calculateme.dto.request.FlooringCalculationRequestDTO;
import com.ains.groupit.calculateme.dto.response.FlooringResponseDTO;
import com.ains.groupit.calculateme.entity.FlooringDetail;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FlooringMapper {
    FlooringDetail toEntity(FlooringCalculationRequestDTO dto);

    FlooringResponseDTO toResponseDTO(FlooringDetail entity);
}

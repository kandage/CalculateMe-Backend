package com.ains.groupit.calculateme.util.mapper;

import com.ains.groupit.calculateme.dto.request.AirConditionerRequestDTO;
import com.ains.groupit.calculateme.entity.AirConditionerDetail;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AirConditionerMapper {
    AirConditionerDetail toEntity(AirConditionerRequestDTO dto);

}

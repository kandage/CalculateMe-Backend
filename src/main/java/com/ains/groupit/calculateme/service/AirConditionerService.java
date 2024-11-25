package com.ains.groupit.calculateme.service;

import com.ains.groupit.calculateme.dto.paginatedDTO.PaginatedAirConditionerCalculationDTO;
import com.ains.groupit.calculateme.dto.request.AirConditionerCalculationRequestDTO;
import com.ains.groupit.calculateme.entity.AirConditionerDetail;

public interface AirConditionerService {
    double calculateACSize(AirConditionerCalculationRequestDTO airConditionerDetail);

    AirConditionerDetail saveRoomDetails(AirConditionerCalculationRequestDTO airConditionerCalculationRequestDTO);

    PaginatedAirConditionerCalculationDTO getAllAirConditioners(int pageNo, int size);

}

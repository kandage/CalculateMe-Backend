package com.ains.groupit.calculateme.service;

import com.ains.groupit.calculateme.dto.paginatedDTO.PaginatedAirConditionerDTO;
import com.ains.groupit.calculateme.dto.request.AirConditionerRequestDTO;
import com.ains.groupit.calculateme.entity.AirConditionerDetail;

public interface AirConditionerService {
    double calculateACSize(AirConditionerRequestDTO airConditionerDetail);
    AirConditionerDetail saveRoomDetails(AirConditionerRequestDTO airConditionerRequestDTO);
    PaginatedAirConditionerDTO getAllAirConditioners(String searchText, int pageNo, int size);

}

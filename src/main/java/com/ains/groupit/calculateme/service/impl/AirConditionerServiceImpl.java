package com.ains.groupit.calculateme.service.impl;

import com.ains.groupit.calculateme.dto.paginatedDTO.PaginatedAirConditionerCalculationDTO;
import com.ains.groupit.calculateme.dto.request.AirConditionerCalculationRequestDTO;
import com.ains.groupit.calculateme.entity.AirConditionerDetail;
import com.ains.groupit.calculateme.repository.RoomDetailsRepository;
import com.ains.groupit.calculateme.service.AirConditionerService;

import com.ains.groupit.calculateme.util.mapper.AirConditionerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


@Service
@RequiredArgsConstructor
public class AirConditionerServiceImpl implements AirConditionerService {
    private final RoomDetailsRepository roomDetailsRepository;
    private final AirConditionerMapper airConditionerMapper;

    @Override
    public double calculateACSize(AirConditionerCalculationRequestDTO airConditionerDetail) {
        double length = airConditionerDetail.getLength();
        double breadth = airConditionerDetail.getBreadth();
        double height = airConditionerDetail.getHeight();
        int personCount = airConditionerDetail.getPersonCount();
        double maximumTemp = airConditionerDetail.getMaxTemperature();

        double noOfPerson;
        double temperature;
        double heightEquation;

        if (personCount <= 3) {
            noOfPerson = 0.3;
        } else {
            noOfPerson = 0.3 + (personCount - 3) * 0.07;
        }

        if (maximumTemp > 45) {
            temperature = 0.5;
        } else if (maximumTemp > 40 && maximumTemp <= 45) {
            temperature = 0.4;
        } else if (maximumTemp > 35 && maximumTemp <= 40) {
            temperature = 0.3;
        } else {
            temperature = 0.2;
        }

        if (height <= 8.0) {
            heightEquation = 0.0;
        } else {
            heightEquation = (height - 8.0) * 0.1;
        }

        return Math.round((((length * breadth * 20) / 12000) + noOfPerson + temperature + heightEquation) * 100.0) / 100.0;
    }

    @Override
    public AirConditionerDetail saveRoomDetails(AirConditionerCalculationRequestDTO airConditionerCalculationRequestDTO) {

        AirConditionerDetail airConditionerDetail = airConditionerMapper.toEntity(airConditionerCalculationRequestDTO);
        double acSize = calculateACSize(airConditionerCalculationRequestDTO);
        airConditionerDetail.setAcSize(acSize);

        return roomDetailsRepository.save(airConditionerDetail);
    }
    @Override
    public PaginatedAirConditionerCalculationDTO getAllAirConditioners(int pageNo, int size) {
        Pageable pageable = PageRequest.of(pageNo, size);

        Page<AirConditionerDetail> airConditioners;

        airConditioners = roomDetailsRepository.findAll(pageable);

        return new PaginatedAirConditionerCalculationDTO(
                airConditioners.getContent(),
                airConditioners.getTotalElements(),
                airConditioners.getTotalPages(),
                pageNo
        );
    }

}

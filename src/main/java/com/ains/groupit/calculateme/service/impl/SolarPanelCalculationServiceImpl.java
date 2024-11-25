package com.ains.groupit.calculateme.service.impl;

import com.ains.groupit.calculateme.dto.paginatedDTO.PaginatedSolarPanelDTO;
import com.ains.groupit.calculateme.dto.request.SolarPanelCalculationRequestDTO;
import com.ains.groupit.calculateme.dto.response.SolarPanelResponseDTO;
import com.ains.groupit.calculateme.entity.SolarPanelDetail;
import com.ains.groupit.calculateme.repository.SolarPanelCalculationRepository;
import com.ains.groupit.calculateme.service.SolarPanelCalculationService;
import com.ains.groupit.calculateme.util.mapper.SolarPanelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SolarPanelCalculationServiceImpl implements SolarPanelCalculationService {

    private final SolarPanelCalculationRepository solarPanelCalculationRepository;
    private final SolarPanelMapper solarPanelMapper;

    @Override
    public SolarPanelResponseDTO calculate(SolarPanelCalculationRequestDTO calculationDTO) {
        double unitCount = calculationDTO.getUnits();
        String typeOfTheMember = calculationDTO.getConsumptionType();

        // Calculate daily consumption based on type
        double dailyConsumption = (typeOfTheMember.equalsIgnoreCase("Monthly")) ?
                Math.round((unitCount / 30) * 100.0) / 100.0 :
                Math.round((unitCount / 365) * 100.0) / 100.0;

        // Calculate rooftop capacity and other values
        double rooftopCapacity = Math.round((dailyConsumption / 4.5) * 100.0) / 100.0;
        int panelNo = (int) Math.round(rooftopCapacity * 3);
        double areaRequired = Math.round((rooftopCapacity * 95) * 100.0) / 100.0;

        // Use the mapper to create the entity and set calculated values
        SolarPanelDetail solarPanelDetail = solarPanelMapper.toEntity(calculationDTO);

        // Set the calculated values to the entity
        solarPanelDetail.setDailyConsumption(dailyConsumption);
        solarPanelDetail.setRooftopCapacity(rooftopCapacity);
        solarPanelDetail.setPanelCount(panelNo);
        solarPanelDetail.setAreaRequired(areaRequired);

        // Save the entity to the database
        solarPanelCalculationRepository.save(solarPanelDetail);

        // Return the response DTO
        return solarPanelMapper.toResponseDTO(solarPanelDetail);
    }

    @Override
    public PaginatedSolarPanelDTO getAllPaginatedSolarPanelDetails(String searchText, int pageNo, int size) {
        Pageable pageable = PageRequest.of(pageNo, size);

        Page<SolarPanelDetail> solarPanelDetails = null;
        if (searchText == null || searchText.isEmpty()) {
            solarPanelDetails = solarPanelCalculationRepository.findAll(pageable);
        }

        assert solarPanelDetails != null;
        return new PaginatedSolarPanelDTO(
                solarPanelDetails.getContent(),
                solarPanelDetails.getTotalElements(),
                solarPanelDetails.getTotalPages(),
                pageNo
        );
    }
}

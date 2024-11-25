package com.ains.groupit.calculateme.service.impl;

import com.ains.groupit.calculateme.dto.paginatedDTO.PaginatedStairCaseCalculationDTO;
import com.ains.groupit.calculateme.dto.request.StairCaseCalculationRequestDTO;
import com.ains.groupit.calculateme.dto.response.StairCaseCalculationResponseDTO;
import com.ains.groupit.calculateme.entity.StairCaseDetail;
import com.ains.groupit.calculateme.repository.StairCaseRepository;
import com.ains.groupit.calculateme.service.StairCaseService;
import com.ains.groupit.calculateme.util.mapper.StairCaseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StairCaseServiceImpl implements StairCaseService {

    private final StairCaseRepository stairCaseRepository;
    private final StairCaseMapper stairCaseMapper;

    @Override
    public StairCaseCalculationResponseDTO calculateStairCase(StairCaseCalculationRequestDTO stairCaseDTO) {
        // Map the request DTO to the entity
        StairCaseDetail stairCaseEntity = stairCaseMapper.toEntity(stairCaseDTO);

        double riseR = stairCaseDTO.getRiser();
        double treaD = stairCaseDTO.getTread();
        double stairwidtH = stairCaseDTO.getStairWidth();
        double stairheighT = stairCaseDTO.getStairHeight();
        double slabthicK = stairCaseDTO.getSlabThickness();

        // Perform calculations
        double numberofRiser = stairheighT / riseR;
        double voltotalstep = (0.5 * riseR * treaD * stairwidtH) * numberofRiser;
        double lengthofWaistslab = numberofRiser / treaD;
        double slantHeighteq = Math.pow(lengthofWaistslab, 2) + Math.pow(10.00, 2);
        double slantHeight = Math.sqrt(slantHeighteq);
        double volumeofWaistslab = stairwidtH * slabthicK * slantHeight;
        double totalVolumeofstair = Math.round((voltotalstep + volumeofWaistslab) * 100.00) / 100.00;
        double dryVolume = (totalVolumeofstair / 35.315) * 1.524;

        double cementVolume, sandVolume, aggregateVolume, sandinTon, aggregateinTon;
        int cementBags;

        String gradeRatio = stairCaseDTO.getGrade();
        switch (gradeRatio) {
            case "M20":
                cementVolume = (dryVolume * 1) / 5.5;
                cementBags = (int) Math.round(cementVolume / 0.035);
                sandVolume = (dryVolume * 1.5) / 5.5;
                sandinTon = Math.round(((sandVolume * 1550) / 1000) * 100.0) / 100.0;
                aggregateVolume = (dryVolume * 3) / 5.5;
                aggregateinTon = Math.round(((aggregateVolume) * 1350 / 1000) * 100.0) / 100.0;
                break;

            case "M15":
                cementVolume = (dryVolume * 1) / 7;
                cementBags = (int) Math.round(cementVolume / 0.035);
                sandVolume = (dryVolume * 1.5) / 7;
                sandinTon = Math.round(((sandVolume * 1550) / 1000) * 100.0) / 100.0;
                aggregateVolume = (dryVolume * 3) / 7;
                aggregateinTon = Math.round(((aggregateVolume) * 1350 / 1000) * 100.0) / 100.0;
                break;

            case "M10":
                cementVolume = (dryVolume * 1) / 10;
                cementBags = (int) Math.round(cementVolume / 0.035);
                sandVolume = (dryVolume * 3) / 10;
                sandinTon = Math.round(((sandVolume * 1550) / 1000) * 100.0) / 100.0;
                aggregateVolume = (dryVolume * 6) / 10;
                aggregateinTon = Math.round(((aggregateVolume) * 1350 / 1000) * 100.0) / 100.0;
                break;

            default:
                cementVolume = (dryVolume * 1) / 13;
                cementBags = (int) Math.round(cementVolume / 0.035);
                sandVolume = (dryVolume * 4) / 13;
                sandinTon = Math.round(((sandVolume * 1550) / 1000) * 100.0) / 100.0;
                aggregateVolume = (dryVolume * 8) / 13;
                aggregateinTon = Math.round(((aggregateVolume) * 1350 / 1000) * 100.0) / 100.0;
                break;
        }

        // Set calculated values to the entity
        stairCaseEntity.setTotalVolumeOfStair(totalVolumeofstair);
        stairCaseEntity.setCementBags(cementBags);
        stairCaseEntity.setSandInTons(sandinTon);
        stairCaseEntity.setAggregateInTons(aggregateinTon);

        // Save the entity to the database
        stairCaseRepository.save(stairCaseEntity);

        // Convert the saved entity to the response DTO
        return stairCaseMapper.toResponseDTO(stairCaseEntity);
    }

    @Override
    public PaginatedStairCaseCalculationDTO getAllPaginatedStairCaseDetails(int pageNo, int size) {
        Pageable pageable = PageRequest.of(pageNo, size);

        Page<StairCaseDetail> stairCaseDetails;

        stairCaseDetails = stairCaseRepository.findAll(pageable);

        return new PaginatedStairCaseCalculationDTO(
                stairCaseDetails.getContent(),
                stairCaseDetails.getTotalElements(),
                stairCaseDetails.getTotalPages(),
                pageNo
        );
    }
}

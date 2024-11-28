package com.ains.groupit.calculateme.service.impl;

import com.ains.groupit.calculateme.dto.response.AllCountResponseDTO;
import com.ains.groupit.calculateme.repository.*;
import com.ains.groupit.calculateme.service.AllCountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AllCountServiceImpl implements AllCountService {
    private final RoomDetailsRepository airConditionerRepo;
    private final AntiTermiteRepository antiTermiteRepo;
    private final BrickRepository brickRepo;
    private final FlooringRepository flooringRepo;
    private final SolarPanelRepository solarRepo;
    private final StairCaseRepository stairRepo;
    private final SteelQuantityRepository steelRepo;
    private final WaterTankRepository waterRepo;
    private final WoodFrameRepository woodRepo;
    @Override
    public AllCountResponseDTO getAllCount() {
        return AllCountResponseDTO.builder()
                .airConditionerDetailCount(airConditionerRepo.count())
                .antiTermiteDetailCount(antiTermiteRepo.count())
                .brickCalculationDetailCount(brickRepo.count())
                .flooringDetailCount(flooringRepo.count())
                .solarPanelDetailCount(solarRepo.count())
                .stairCaseDetailCount(stairRepo.count())
                .steelQuantityDetailCount(steelRepo.count())
                .waterTankDetailCount(waterRepo.count())
                .woodFrameDetailCount(woodRepo.count())
                .build();
    }
}

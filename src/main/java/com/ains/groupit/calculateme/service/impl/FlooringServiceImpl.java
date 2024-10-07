package com.ains.groupit.calculateme.service.impl;

import com.ains.groupit.calculateme.dto.request.FlooringRequestDTO;
import com.ains.groupit.calculateme.dto.response.FlooringResponseDTO;
import com.ains.groupit.calculateme.entity.FlooringDetail;
import com.ains.groupit.calculateme.repository.FlooringRepository;
import com.ains.groupit.calculateme.service.FlooringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlooringServiceImpl implements FlooringService {

    @Autowired
    private FlooringRepository flooringRepository;

    @Override
    public FlooringResponseDTO calculateAndSaveFlooring(FlooringRequestDTO requestDTO) {
        double floorLength = requestDTO.getFloorLength();
        double floorWidth = requestDTO.getFloorWidth();
        double tileLength = requestDTO.getTileLength();
        double tileWidth = requestDTO.getTileWidth();

        // Validate inputs
        if (floorLength <= 0 || floorWidth <= 0 || tileLength <= 0 || tileWidth <= 0) {
            return new FlooringResponseDTO(0, 0, 0, "All inputs should be positive.");
        }

        // Calculate the tile area and floor area
        double tileArea = tileLength * tileWidth;
        double floorArea = floorLength * floorWidth;

        // Calculate the number of tiles required
        int numTiles = (int) Math.ceil(floorArea / tileArea);

        // Calculate the volume of bedding with thickness 0.07m
        double volumeWithBedding = floorArea * 0.07;

        // Calculate the number of cement bags (each bag is 0.035 cubic meters)
        int cementBags = (int) Math.ceil((volumeWithBedding / 7) / 0.035);

        // Calculate the quantity of sand (density of sand = 1550 kg/m³)
        double sandQuantity = Math.round((((volumeWithBedding * 6) / 7) * 1550) * 100) / 100.0;

        // Create and save entity to the database
        FlooringDetail flooringDetails = new FlooringDetail(null, floorLength, floorWidth, tileLength, tileWidth, numTiles, cementBags, sandQuantity);
        flooringRepository.save(flooringDetails);

        // Create response DTO
        return new FlooringResponseDTO(numTiles, cementBags, sandQuantity, "Calculation successful and data saved.");
    }


}

package com.ains.groupit.calculateme.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FlooringDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double floorLength;
    private double floorWidth;
    private double tileLength;
    private double tileWidth;

    private int numberOfTiles;
    private int cementBags;
    private double sandQuantity;
}

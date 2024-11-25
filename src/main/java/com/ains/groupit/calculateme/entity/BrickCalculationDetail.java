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
public class BrickCalculationDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double wallLength;
    private double wallHeight;
    private double wallThickness;

    private double brickLength;
    private double brickWidth;
    private double brickHeight;

    private String cementRatio;

    private int numberOfBricks;
    private int cementBags;
    private double sandQuantity;
}


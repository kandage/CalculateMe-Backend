package com.ains.groupit.calculateme.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StairCaseDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double riser;
    private double tread;
    private double stairWidth;
    private double stairHeight;
    private double slabThickness;
    private String grade;

    private double totalVolumeOfStair;
    private double cementBags;
    private double sandInTons;
    private double aggregateInTons;
}

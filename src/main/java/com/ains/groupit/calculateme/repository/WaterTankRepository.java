package com.ains.groupit.calculateme.repository;

import com.ains.groupit.calculateme.entity.WaterTankDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaterTankRepository extends JpaRepository<WaterTankDetail, Long> {
}
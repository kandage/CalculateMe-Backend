package com.ains.groupit.calculateme.repository;

import com.ains.groupit.calculateme.entity.BrickCalculationDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrickCalculationRepository extends JpaRepository<BrickCalculationDetail, Long> {
}

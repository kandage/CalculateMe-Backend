package com.ains.groupit.calculateme.repository;

import com.ains.groupit.calculateme.entity.SolarPanelDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolarPanelCalculationRepository extends JpaRepository<SolarPanelDetail, Long> {

}

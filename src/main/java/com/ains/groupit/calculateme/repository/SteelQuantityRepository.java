package com.ains.groupit.calculateme.repository;

import com.ains.groupit.calculateme.entity.SteelQuantityDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SteelQuantityRepository extends JpaRepository<SteelQuantityDetails, Long> {
}

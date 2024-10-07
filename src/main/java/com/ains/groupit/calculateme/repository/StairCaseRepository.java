package com.ains.groupit.calculateme.repository;

import com.ains.groupit.calculateme.entity.StairCaseDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StairCaseRepository extends JpaRepository<StairCaseDetail, Long> {
}

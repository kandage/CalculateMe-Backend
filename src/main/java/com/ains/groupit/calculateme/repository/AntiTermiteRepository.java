package com.ains.groupit.calculateme.repository;

import com.ains.groupit.calculateme.entity.AntiTermiteDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AntiTermiteRepository extends JpaRepository<AntiTermiteDetail, Long> {
}

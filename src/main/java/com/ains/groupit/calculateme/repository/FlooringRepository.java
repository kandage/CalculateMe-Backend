package com.ains.groupit.calculateme.repository;

import com.ains.groupit.calculateme.entity.FlooringDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlooringRepository extends JpaRepository<FlooringDetail, Long> {
}
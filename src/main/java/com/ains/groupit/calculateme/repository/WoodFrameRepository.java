package com.ains.groupit.calculateme.repository;

import com.ains.groupit.calculateme.entity.WoodFrameDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WoodFrameRepository extends JpaRepository<WoodFrameDetail, Long> {
}

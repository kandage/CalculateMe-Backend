package com.ains.groupit.calculateme.repository;

import com.ains.groupit.calculateme.entity.AirConditionerDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomDetailsRepository extends JpaRepository<AirConditionerDetail, String> {
}
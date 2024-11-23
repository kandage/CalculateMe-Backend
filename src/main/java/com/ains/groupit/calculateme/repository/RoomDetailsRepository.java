package com.ains.groupit.calculateme.repository;

import com.ains.groupit.calculateme.entity.AirConditionerDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

@Repository
public interface RoomDetailsRepository extends JpaRepository<AirConditionerDetail, String> {
    @Query("SELECT a FROM AirConditionerDetail a WHERE " +
            "CAST(a.length AS string) LIKE %:searchText% OR " +
            "CAST(a.breadth AS string) LIKE %:searchText% OR " +
            "CAST(a.height AS string) LIKE %:searchText% OR " +
            "CAST(a.personCount AS string) LIKE %:searchText% OR " +
            "CAST(a.maxTemperature AS string) LIKE %:searchText% OR " +
            "CAST(a.acSize AS string) LIKE %:searchText%")
    Page<AirConditionerDetail> searchByFields(@Param("searchText") String searchText, Pageable pageable);}

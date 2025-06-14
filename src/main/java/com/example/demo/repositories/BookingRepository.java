package com.example.demo.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Booking;
import com.example.demo.entities.Status;

public interface BookingRepository extends JpaRepository<Booking, Long>{
    @Query("SELECT b FROM Booking b WHERE b.unit.id = :unitId AND b.status IN (:statuses) AND (b.startDate <= :endDate AND b.endDate >= :startDate)")
    List<Booking> findActiveBookingsByUnitAndDateRange(
        @Param("unitId") Long unitId,
        @Param("startDate") LocalDate startDate,
        @Param("endDate") LocalDate endDate,
        @Param("statuses") List<Status> statuses
    );
}

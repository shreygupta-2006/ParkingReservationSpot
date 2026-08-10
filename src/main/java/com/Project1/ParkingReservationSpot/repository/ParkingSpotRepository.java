package com.Project1.ParkingReservationSpot.repository;

import com.Project1.ParkingReservationSpot.entity.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, Integer> {
}

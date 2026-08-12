package com.Project1.ParkingReservationSpot.repository;

import com.Project1.ParkingReservationSpot.entity.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, Integer> {
    boolean existsBySpotName(String parkingSpotName);

    ParkingSpot findBySpotName(String parkingSpotName);
}

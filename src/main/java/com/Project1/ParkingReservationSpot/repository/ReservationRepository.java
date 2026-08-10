package com.Project1.ParkingReservationSpot.repository;

import com.Project1.ParkingReservationSpot.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}

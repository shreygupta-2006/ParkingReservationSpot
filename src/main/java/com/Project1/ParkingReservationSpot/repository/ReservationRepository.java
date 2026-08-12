package com.Project1.ParkingReservationSpot.repository;

import com.Project1.ParkingReservationSpot.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    boolean existsByDate(LocalDate checkDate);

    List<Reservation> findByDate(LocalDate date);

    List<Reservation> findByParkingSpotId(Integer spotId);

}

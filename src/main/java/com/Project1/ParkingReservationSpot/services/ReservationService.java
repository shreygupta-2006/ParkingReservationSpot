package com.Project1.ParkingReservationSpot.services;

import com.Project1.ParkingReservationSpot.dto.AddReservationDTO;
import com.Project1.ParkingReservationSpot.dto.ReservationDTO;

import java.time.LocalDate;
import java.util.List;

public interface ReservationService {

    ReservationDTO addNewReservation(AddReservationDTO addReservationDTO);

    List<ReservationDTO> findReservationByDate(LocalDate date);

    List<ReservationDTO> findReservations();
}

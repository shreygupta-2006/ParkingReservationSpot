package com.Project1.ParkingReservationSpot.services;

import com.Project1.ParkingReservationSpot.dto.AddParkingSpotDTO;
import com.Project1.ParkingReservationSpot.dto.ParkingSpotDTO;

import java.util.List;

public interface ParkingSpotService {
    ParkingSpotDTO addNewParkingSpot(AddParkingSpotDTO addParkingSpotDTO);

    List<ParkingSpotDTO> getParkingSpots();
}

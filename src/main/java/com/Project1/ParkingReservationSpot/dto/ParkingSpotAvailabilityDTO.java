package com.Project1.ParkingReservationSpot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParkingSpotAvailabilityDTO {
    String parkingSpotName;
    List<ReservationDTO> reservations;
}

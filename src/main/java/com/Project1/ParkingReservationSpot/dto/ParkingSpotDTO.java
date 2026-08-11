package com.Project1.ParkingReservationSpot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParkingSpotDTO {
    private Integer id;
    private String spotName;
}


package com.Project1.ParkingReservationSpot.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class AddParkingSpotDTO {
    @NotBlank
    private String spotName;
}

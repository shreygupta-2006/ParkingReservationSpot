package com.Project1.ParkingReservationSpot.dto;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddReservationDTO {
    @NotNull
    private LocalDate date;
    @NotNull
    private LocalTime startTime;
    @NotNull
    private LocalTime endTime;
    @NotNull
    private String customerFirstName;
    @NotNull
    private String customerLastName;
    @NotNull
    private String customerEmail;
    @NotNull
    private String customerPhoneNumber;
    @NotNull
    private Integer parkingSpotId;

}

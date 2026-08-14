package com.Project1.ParkingReservationSpot.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank
    private String customerFirstName;
    @NotBlank
    private String customerLastName;
    @NotBlank
    @Email
    private String customerEmail;
    @NotBlank
    private String customerPhoneNumber;
    @NotNull
    private Integer parkingSpotId;

}

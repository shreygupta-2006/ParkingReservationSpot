package com.Project1.ParkingReservationSpot.dto;


import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class UpdateCustomerDTO {

    private String firstName;
    private String lastName;
    @Email
    private String email;
    private String phoneNumber;
}

package com.Project1.ParkingReservationSpot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCustomerDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}

package com.Project1.ParkingReservationSpot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    LocalDate date;
    LocalTime startTime;
    LocalTime endTime;

    @ManyToOne
    @JoinColumn(name = "CustomerId")
    Customer customer;

    @ManyToOne
    private ParkingSpot parkingSpot;
}

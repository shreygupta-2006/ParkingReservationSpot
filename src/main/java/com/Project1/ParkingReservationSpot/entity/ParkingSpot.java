package com.Project1.ParkingReservationSpot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class ParkingSpot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "spotName", nullable = false)
    private String spotName;

    @OneToMany(mappedBy = "parkingSpot")
    private List<Reservation> reservation;

}

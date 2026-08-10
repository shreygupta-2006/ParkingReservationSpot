package com.Project1.ParkingReservationSpot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private Integer id;
    @Column(name = "FirstName", nullable = false)
    private String firstName;
    @Column(name = "LastName", nullable = false)
    private String lastName;
    @Column(name = "Email", nullable = false, unique = true)
    private String email;
    @Column(name = "PhoneNumber", nullable = false, unique = true)
    private String phoneNumber;

    @OneToMany(mappedBy = "customer")
    private List<Reservation> reservation;
}

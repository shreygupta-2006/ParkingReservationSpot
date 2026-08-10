package com.Project1.ParkingReservationSpot.repository;

import com.Project1.ParkingReservationSpot.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}

package com.Project1.ParkingReservationSpot.repository;

import com.Project1.ParkingReservationSpot.entity.Customer;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    boolean existsByPhoneNumber(@NotNull String phoneNumber);

    Customer findByPhoneNumber(@NotNull String phoneNumber);
}

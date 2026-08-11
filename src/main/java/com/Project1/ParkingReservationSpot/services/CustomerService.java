package com.Project1.ParkingReservationSpot.services;

import com.Project1.ParkingReservationSpot.dto.AddCustomerDTO;
import com.Project1.ParkingReservationSpot.dto.CustomerDTO;
import com.Project1.ParkingReservationSpot.dto.UpdateCustomerDTO;
import jakarta.validation.Valid;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> getAllCustomers();

    CustomerDTO addNewCustomer(AddCustomerDTO addCustomerDTO);

    CustomerDTO getCustomerbyId(Integer id);

    void deleteCustomerById(Integer id);

    CustomerDTO updateCustomerById(Integer id, UpdateCustomerDTO updateCustomerDTO);
}

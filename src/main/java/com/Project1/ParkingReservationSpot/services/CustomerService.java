package com.Project1.ParkingReservationSpot.services;

import com.Project1.ParkingReservationSpot.dto.AddCustomerDTO;
import com.Project1.ParkingReservationSpot.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> getAllCustomers();

    CustomerDTO addNewCustomer(AddCustomerDTO addCustomerDTO);

    CustomerDTO getCustomerbyID(int id);
}

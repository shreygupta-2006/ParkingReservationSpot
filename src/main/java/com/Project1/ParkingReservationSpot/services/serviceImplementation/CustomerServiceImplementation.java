package com.Project1.ParkingReservationSpot.services.serviceImplementation;

import com.Project1.ParkingReservationSpot.dto.AddCustomerDTO;
import com.Project1.ParkingReservationSpot.dto.CustomerDTO;
import com.Project1.ParkingReservationSpot.entity.Customer;
import com.Project1.ParkingReservationSpot.repository.CustomerRepository;
import com.Project1.ParkingReservationSpot.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImplementation implements CustomerService {
    private final CustomerRepository customerRepository;
    @Override
    public List<CustomerDTO> getAllCustomers() {
       List<Customer> customers = customerRepository.findAll();
       return customers.stream()
               .map(customer -> new CustomerDTO(customer.getId(),customer.getFirstName(),
                       customer.getLastName(),customer.getEmail(),customer.getPhoneNumber()))
               .toList();
    }

    @Override
    public CustomerDTO addNewCustomer(AddCustomerDTO addCustomerDTO) {
        Customer newCustomer = new Customer();
        newCustomer.setFirstName(addCustomerDTO.getFirstName());
        newCustomer.setLastName(addCustomerDTO.getLastName());
        newCustomer.setEmail(addCustomerDTO.getEmail());
        newCustomer.setPhoneNumber(addCustomerDTO.getPhoneNumber());
        customerRepository.save(newCustomer);

        return new CustomerDTO(newCustomer.getId(),newCustomer.getFirstName(),
                newCustomer.getLastName(), newCustomer.getEmail(),newCustomer.getPhoneNumber());
    }

    @Override
    public CustomerDTO getCustomerbyID(int id) {
        Customer customer=customerRepository.findById(id).orElseThrow();
        return new CustomerDTO(customer.getId(),customer.getFirstName(),customer.getLastName()
                ,customer.getEmail(),customer.getPhoneNumber());
    }
}

package com.Project1.ParkingReservationSpot.services.serviceImplementation;

import com.Project1.ParkingReservationSpot.dto.AddCustomerDTO;
import com.Project1.ParkingReservationSpot.dto.CustomerDTO;
import com.Project1.ParkingReservationSpot.dto.UpdateCustomerDTO;
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
    public CustomerDTO getCustomerbyId(Integer id) {
        Customer customer=customerRepository.findById(id).orElseThrow();
        return new CustomerDTO(customer.getId(),customer.getFirstName(),customer.getLastName()
                ,customer.getEmail(),customer.getPhoneNumber());
    }

    @Override
    public void deleteCustomerById(Integer id) {
        if(customerRepository.existsById(id)){
            customerRepository.deleteById(id);
        }
        else throw new IllegalArgumentException("Customer id not found");
    }

    @Override
    public CustomerDTO updateCustomerById(Integer id, UpdateCustomerDTO updateCustomerDTO) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        if(updateCustomerDTO.getFirstName() != null){
            customer.setFirstName(updateCustomerDTO.getFirstName());
        }
         if(updateCustomerDTO.getLastName() != null){
            customer.setLastName(updateCustomerDTO.getLastName());
        }
         if(updateCustomerDTO.getEmail() != null){
            customer.setEmail(updateCustomerDTO.getEmail());
        }
         if(updateCustomerDTO.getPhoneNumber() != null){
            customer.setPhoneNumber(updateCustomerDTO.getPhoneNumber());
        }
        Customer savedCustomer = customerRepository.save(customer);
        return new CustomerDTO(savedCustomer.getId(), savedCustomer.getFirstName(),
                savedCustomer.getLastName(), savedCustomer.getEmail(), savedCustomer.getPhoneNumber());
    }
}

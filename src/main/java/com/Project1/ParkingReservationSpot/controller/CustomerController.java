package com.Project1.ParkingReservationSpot.controller;

import com.Project1.ParkingReservationSpot.dto.AddCustomerDTO;
import com.Project1.ParkingReservationSpot.dto.CustomerDTO;
import com.Project1.ParkingReservationSpot.dto.UpdateCustomerDTO;
import com.Project1.ParkingReservationSpot.services.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/private")
    public ResponseEntity<List<CustomerDTO>> getCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());

    }

    @GetMapping("/private/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable int id) {
        return ResponseEntity.ok(customerService.getCustomerbyId(id));
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> addCustomer(
            @Valid @RequestBody AddCustomerDTO addCustomerDTO
    ){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(customerService.addNewCustomer(addCustomerDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomerDTO> deleteCustomer( @PathVariable Integer id){
        customerService.deleteCustomerById(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable Integer id, @Valid @RequestBody UpdateCustomerDTO updateCustomerDTO) {
        return ResponseEntity.ok().body(customerService.updateCustomerById(id,updateCustomerDTO));
    }

}

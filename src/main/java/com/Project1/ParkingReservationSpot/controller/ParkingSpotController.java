package com.Project1.ParkingReservationSpot.controller;


import com.Project1.ParkingReservationSpot.dto.AddParkingSpotDTO;
import com.Project1.ParkingReservationSpot.dto.ParkingSpotDTO;
import com.Project1.ParkingReservationSpot.services.ParkingSpotService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/parkingSpot")
public class ParkingSpotController {

    private final ParkingSpotService parkingSpotService;

    @PostMapping
    public ResponseEntity<ParkingSpotDTO> addParkingSpot(@RequestBody @Valid AddParkingSpotDTO addParkingSpotDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.addNewParkingSpot(addParkingSpotDTO));
    }

    @GetMapping
    public ResponseEntity<List<ParkingSpotDTO>> getAllParkingSpots() {
        return ResponseEntity.ok().body(parkingSpotService.getParkingSpots());
    }

}

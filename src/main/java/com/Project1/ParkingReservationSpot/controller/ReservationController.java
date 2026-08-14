package com.Project1.ParkingReservationSpot.controller;

import com.Project1.ParkingReservationSpot.dto.AddReservationDTO;
import com.Project1.ParkingReservationSpot.dto.ReservationDTO;
import com.Project1.ParkingReservationSpot.services.ReservationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reservation")
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping("/public")
    public ResponseEntity<ReservationDTO> addReservation(@RequestBody @Valid AddReservationDTO addReservationDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reservationService.addNewReservation(addReservationDTO));
    }

    @GetMapping("public/{date}")
    public ResponseEntity<List<ReservationDTO>> getReservationsByDate(@PathVariable("date") LocalDate date){
        return ResponseEntity.ok().body(reservationService.findReservationByDate(date));
    }

    @GetMapping
    public ResponseEntity<List<ReservationDTO>> getAllReservations(){
        return ResponseEntity.ok().body(reservationService.findReservations());
    }
}

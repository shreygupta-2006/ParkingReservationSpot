package com.Project1.ParkingReservationSpot.services.serviceImplementation;

import com.Project1.ParkingReservationSpot.dto.AddParkingSpotDTO;
import com.Project1.ParkingReservationSpot.dto.ParkingSpotAvailabilityDTO;
import com.Project1.ParkingReservationSpot.dto.ParkingSpotDTO;
import com.Project1.ParkingReservationSpot.dto.ReservationDTO;
import com.Project1.ParkingReservationSpot.entity.ParkingSpot;
import com.Project1.ParkingReservationSpot.entity.Reservation;
import com.Project1.ParkingReservationSpot.repository.ParkingSpotRepository;
import com.Project1.ParkingReservationSpot.repository.ReservationRepository;
import com.Project1.ParkingReservationSpot.services.ParkingSpotService;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class ParkingSpotServiceImplementation implements ParkingSpotService {
    private final ParkingSpotRepository parkingSpotRepository;
    private final ReservationRepository reservationRepository;
    private final ModelMapper modelMapper;

    @Override
    public ParkingSpotDTO addNewParkingSpot(AddParkingSpotDTO addParkingSpotDTO) {
        ParkingSpot parkingSpot = new ParkingSpot();
        parkingSpot.setSpotName(addParkingSpotDTO.getSpotName());
        parkingSpotRepository.save(parkingSpot);
        return new ParkingSpotDTO(parkingSpot.getId(),parkingSpot.getSpotName());
    }

    @Override
    public List<ParkingSpotDTO> getParkingSpots() {
        List<ParkingSpot> parkingSpots = parkingSpotRepository.findAll();
        return parkingSpots.stream()
                .map(parkingSpot -> new ParkingSpotDTO(parkingSpot.getId(),parkingSpot.getSpotName()))
                .toList();
    }

    @Override
    public ParkingSpotAvailabilityDTO checkParkingSpot(String parkingSpotName) {
        if(!parkingSpotRepository.existsBySpotName(parkingSpotName)){
            throw new IllegalArgumentException("Parking Spot does not exist");
        }
        ParkingSpot parkingSpot=parkingSpotRepository.findBySpotName(parkingSpotName);
        Integer id=parkingSpot.getId();
        List<Reservation> reservations=reservationRepository.findByParkingSpotId(id);
        List<ReservationDTO> reservationDTOs = reservations.stream()
                .map(reservation -> modelMapper.map(reservation, ReservationDTO.class))
                .toList();
        return new ParkingSpotAvailabilityDTO(parkingSpotName,reservationDTOs);

    }
}

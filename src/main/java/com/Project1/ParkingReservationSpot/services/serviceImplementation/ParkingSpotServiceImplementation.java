package com.Project1.ParkingReservationSpot.services.serviceImplementation;

import com.Project1.ParkingReservationSpot.dto.AddParkingSpotDTO;
import com.Project1.ParkingReservationSpot.dto.ParkingSpotDTO;
import com.Project1.ParkingReservationSpot.entity.ParkingSpot;
import com.Project1.ParkingReservationSpot.repository.ParkingSpotRepository;
import com.Project1.ParkingReservationSpot.services.ParkingSpotService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParkingSpotServiceImplementation implements ParkingSpotService {
    private final ParkingSpotRepository parkingSpotRepository;


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
}

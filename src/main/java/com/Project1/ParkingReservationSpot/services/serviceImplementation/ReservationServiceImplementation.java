package com.Project1.ParkingReservationSpot.services.serviceImplementation;

import com.Project1.ParkingReservationSpot.dto.AddReservationDTO;
import com.Project1.ParkingReservationSpot.dto.ReservationDTO;
import com.Project1.ParkingReservationSpot.entity.Reservation;
import com.Project1.ParkingReservationSpot.repository.CustomerRepository;
import com.Project1.ParkingReservationSpot.repository.ParkingSpotRepository;
import com.Project1.ParkingReservationSpot.repository.ReservationRepository;
import com.Project1.ParkingReservationSpot.services.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImplementation implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final ParkingSpotRepository parkingSpotRepository;
    private final CustomerRepository customerRepository;

    @Override
    public ReservationDTO addNewReservation(AddReservationDTO addReservationDTO) {

        if(!customerRepository.existsById(addReservationDTO.getCustomerId())|| !parkingSpotRepository.existsById(addReservationDTO.getParkingSpotId())){
            throw new IllegalArgumentException("Customer and Parking Spot not found");
        }
        checkBooking(addReservationDTO);
        Reservation newReservation=new Reservation();
        newReservation.setCustomer(customerRepository.findById(addReservationDTO.getCustomerId()).orElseThrow());
        newReservation.setParkingSpot(parkingSpotRepository.findById(addReservationDTO.getParkingSpotId()).orElseThrow());

        newReservation.setDate(addReservationDTO.getDate());
        newReservation.setStartTime(addReservationDTO.getStartTime());
        newReservation.setEndTime(addReservationDTO.getEndTime());

        reservationRepository.save(newReservation);

        return new ReservationDTO(newReservation.getId(),newReservation.getDate(),
                newReservation.getStartTime(),newReservation.getEndTime(),
                newReservation.getCustomer().getId(), newReservation.getParkingSpot().getId());
    }

    @Override
    public List<ReservationDTO> findReservationByDate(LocalDate date) {
        if(!reservationRepository.existsByDate(date)){
            throw new IllegalArgumentException("No reservations found");
        }
        List<Reservation> reservations=reservationRepository.findByDate(date);
        return reservations.stream()
                .map(reservation -> new ReservationDTO(reservation.getId(),reservation.getDate(),
                        reservation.getStartTime(),reservation.getEndTime(), reservation.getCustomer().getId(),

                        reservation.getParkingSpot().getId()))
                .toList();
    }

    @Override
    public List<ReservationDTO> findReservations() {
        List<Reservation> reservations=reservationRepository.findAll();
        return reservations.stream()
                .map(reservation -> new ReservationDTO(reservation.getId(),
                        reservation.getDate(),reservation.getStartTime(),reservation.getEndTime(),
                        reservation.getCustomer().getId(),reservation.getParkingSpot().getId()))
                .toList();
    }

    public void checkBooking(AddReservationDTO addReservationDTO) {
        LocalDate checkDate=addReservationDTO.getDate();
        LocalTime checkEndTime =addReservationDTO.getEndTime();
        LocalTime checkStartTime =addReservationDTO.getStartTime();
        if(checkStartTime.isAfter(checkEndTime) || checkStartTime.equals(checkEndTime))
            throw new IllegalArgumentException("Start Time must be before End Time");
        LocalTime existingStartTime;
        LocalTime existingEndTime;
        Integer existingParkingSpot;
        if(reservationRepository.existsByDate(checkDate)){
            List<Reservation> existBooking=reservationRepository.findByDate(checkDate);
            for(Reservation reservation:existBooking){
                existingStartTime =reservation.getStartTime();
                existingEndTime =reservation.getEndTime();
                existingParkingSpot=reservation.getParkingSpot().getId();
                if(existingParkingSpot.equals(addReservationDTO.getParkingSpotId())){
                if(existingStartTime.isBefore(checkEndTime)&&existingEndTime.isAfter(checkStartTime)){
                    throw new IllegalArgumentException("Booking is already booked");
                }
                }
            }


        }


    }
}


package com.example.service;

import com.example.entity.Flight;
import com.example.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService {
    @Autowired
    FlightRepository flightRepository;

    public List<Flight> getAllFlight() {
        List<Flight> list = flightRepository.findAll().stream()
                .filter(f -> LocalDateTime.of(f.getFlightDate(), f.getFlightTime().plusHours(1)).compareTo(LocalDateTime.now()) >= 0)
                .filter(f -> f.getFlightInfo().getCountSeats().compareTo(0)>0)
                .collect(Collectors.toList());
        return flightRepository.findAll();
    }

    public Flight flightSave(Flight flight) {
        return flightRepository.save(flight);
    }
//    public boolean buyFlight(){
//
//    }
}
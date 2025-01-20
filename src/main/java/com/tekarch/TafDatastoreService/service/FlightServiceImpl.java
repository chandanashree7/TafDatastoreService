package com.tekarch.TafDatastoreService.service;

import com.tekarch.TafDatastoreService.entities.Flights;
import com.tekarch.TafDatastoreService.model.FlightDTO;
import com.tekarch.TafDatastoreService.repository.FlightRepository;
import com.tekarch.TafDatastoreService.service.Interface.FlightServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightServiceInterface {

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public List<Flights> getFlights() {
        return flightRepository.findAll();
    }

    @Override
    public Flights getFlightById(Long id) {
        return flightRepository.findById(id).orElse(null);
    }

    @Override
    public Flights saveFlight(FlightDTO flight) {
        Flights flights = new Flights();
        flights.setFlightNumber(flight.getFlightNumber());
        flights.setArrival(flight.getArrival());
        flights.setAvailableSeats(flight.getAvailableSeats());
        flights.setDeparture(flight.getDeparture());
        flights.setPrice(flight.getPrice());
        flights.setDepartureTime(flight.getDepartureTime());
        flights.setArrivalTime(flight.getArrivalTime());
        flights.setCreatedAt(LocalDateTime.now());

        return flightRepository.save(flights);
    }

    @Override
    public Flights updateFlight(FlightDTO flight,Long flightId) {
        Flights flights = new Flights();
        flights.setId(flightId);
        flights.setFlightNumber(flight.getFlightNumber());
        if (flight.getArrival() != null && !flight.getArrival().trim().isEmpty()) {
            flights.setArrival(flight.getArrival());
        }
        if(flight.getAvailableSeats() != null && flight.getAvailableSeats() >= 0) {
            flights.setAvailableSeats(flight.getAvailableSeats());
        }
        if (flight.getDeparture() != null && !flight.getDeparture().trim().isEmpty()) {
            flights.setDeparture(flight.getDeparture());
        }
        if(flight.getPrice() != null && flight.getPrice()>0) {
            flights.setPrice(flight.getPrice());
        }
        if(flight.getDepartureTime()!=null) {
            flights.setDepartureTime(flight.getDepartureTime());
        }
        if(flight.getArrivalTime()!=null){
            flights.setArrivalTime(flight.getArrivalTime());
        }
        flights.setUpdatedAt(LocalDateTime.now());
        return flightRepository.save(flights);
    }

    @Override
    public void deleteFlight(Long flightId) {
        flightRepository.deleteById(flightId);
    }


}

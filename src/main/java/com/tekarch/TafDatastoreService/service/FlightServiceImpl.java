package com.tekarch.TafDatastoreService.service;

import com.tekarch.TafDatastoreService.entities.Flights;
import com.tekarch.TafDatastoreService.model.FlightRequest;
import com.tekarch.TafDatastoreService.model.FlightResponse;
import com.tekarch.TafDatastoreService.repository.FlightRepository;
import com.tekarch.TafDatastoreService.service.Interface.FlightServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightServiceInterface {

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public List<FlightResponse> getFlights() {
        List<Flights> details = flightRepository.findAll();
        List<FlightResponse> flightResponses = new ArrayList<>();
        for (Flights detail: details){
            flightResponses.add(mapFlightDetails(detail));
        }
        return flightResponses;
    }

    @Override
    public FlightResponse getFlightById(Long id) {
        return mapFlightDetails(flightRepository.findById(id).orElse(null));
    }

    @Override
    public FlightResponse saveFlight(FlightRequest flight) {
        Flights flights = new Flights();
        flights.setFlightNumber(flight.getFlightNumber());
        flights.setArrival(flight.getArrival());
        flights.setAvailableSeats(flight.getAvailableSeats());
        flights.setDeparture(flight.getDeparture());
        flights.setPrice(flight.getPrice());
        flights.setDepartureTime(flight.getDepartureTime());
        flights.setArrivalTime(flight.getArrivalTime());
        flights.setCreatedAt(LocalDateTime.now());

        return mapFlightDetails(flightRepository.save(flights));
    }

    @Override
    public FlightResponse updateFlight(FlightRequest flight, Long flightId) {
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
        return mapFlightDetails(flightRepository.save(flights));
    }

    @Override
    public void deleteFlight(Long flightId) {
        flightRepository.deleteById(flightId);
    }

    private FlightResponse mapFlightDetails(Flights flight){
        FlightResponse response = new FlightResponse();
        if(flight != null) {
            response.setId(flight.getId());
            response.setFlightNumber(flight.getFlightNumber());
            response.setArrival(flight.getArrival());
            response.setAvailableSeats(flight.getAvailableSeats());
            response.setDeparture(flight.getDeparture());
            response.setPrice(flight.getPrice());
            response.setDepartureTime(flight.getDepartureTime());
            response.setArrivalTime(flight.getArrivalTime());
        }
        return response;
    }
}

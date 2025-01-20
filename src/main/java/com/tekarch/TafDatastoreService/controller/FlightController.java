package com.tekarch.TafDatastoreService.controller;

import com.tekarch.TafDatastoreService.entities.Flights;
import com.tekarch.TafDatastoreService.model.FlightRequest;
import com.tekarch.TafDatastoreService.model.FlightResponse;
import com.tekarch.TafDatastoreService.service.FlightServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FlightController {

    @Autowired
    private FlightServiceImpl flightService;

    @GetMapping("/flights")
    public ResponseEntity<List<FlightResponse>> getAllFlights() {
        return new ResponseEntity<>(flightService.getFlights(), HttpStatus.OK);
    }

    @GetMapping("/flights/{flightId}")
    public ResponseEntity<FlightResponse> getFlightById(@PathVariable Long flightId) {
        FlightResponse flight = flightService.getFlightById(flightId);
        return (flight != null) ? ResponseEntity.status(HttpStatus.OK).body(flight) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(flight);
    }

    @PostMapping("/flights")
    public ResponseEntity<FlightResponse> createFlight(@RequestBody FlightRequest flight) {
        FlightResponse createdFlight = flightService.saveFlight(flight);
        return new ResponseEntity<>(createdFlight, HttpStatus.CREATED);
    }

    @PutMapping("/flights/{flightId}")
    public ResponseEntity<FlightResponse> updateFlight(@RequestBody FlightRequest flight, @PathVariable Long flightId) {
        FlightResponse updateFlight = flightService.updateFlight(flight, flightId);
        return new ResponseEntity<>(updateFlight, HttpStatus.CREATED);
    }

    @DeleteMapping("/flights/{flightId}")
    public ResponseEntity<String> deleteFlight(@PathVariable Long flightId) {
        flightService.deleteFlight(flightId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

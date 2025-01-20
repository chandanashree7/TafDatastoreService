package com.tekarch.TafDatastoreService.controller;

import com.tekarch.TafDatastoreService.entities.Flights;
import com.tekarch.TafDatastoreService.entities.Users;
import com.tekarch.TafDatastoreService.model.FlightDTO;
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
    public ResponseEntity<List<Flights>> getAllFlights() {
        return new ResponseEntity<>(flightService.getFlights(), HttpStatus.OK);
    }

    @GetMapping("/flights/{flightId}")
    public ResponseEntity<Flights> getFlightById(@PathVariable Long flightId) {
        Flights flight = flightService.getFlightById(flightId);
        return (flight != null) ? ResponseEntity.status(HttpStatus.OK).body(flight) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(flight);
    }

    @PostMapping("/flights")
    public ResponseEntity<Flights> createFlight(@RequestBody FlightDTO flight) {
        Flights createdFlight = flightService.saveFlight(flight);
        return new ResponseEntity<>(createdFlight, HttpStatus.CREATED);
    }

    @PutMapping("/flights/{flightId}")
    public ResponseEntity<Flights> updateFlight(@RequestBody FlightDTO flight,@PathVariable Long flightId) {
        Flights updateFlight = flightService.updateFlight(flight, flightId);
        return new ResponseEntity<>(updateFlight, HttpStatus.CREATED);
    }

    @DeleteMapping("/flights/{flightId}")
    public ResponseEntity<String> deleteFlight(@PathVariable Long flightId) {
        flightService.deleteFlight(flightId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

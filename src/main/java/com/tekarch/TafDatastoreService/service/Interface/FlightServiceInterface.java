package com.tekarch.TafDatastoreService.service.Interface;

import com.tekarch.TafDatastoreService.entities.Flights;
import com.tekarch.TafDatastoreService.model.FlightDTO;

import java.util.List;

public interface FlightServiceInterface {

    List<Flights> getFlights();
    Flights getFlightById(Long flightId);
    Flights saveFlight(FlightDTO flight);
    Flights updateFlight(FlightDTO flights,Long flightId);
    void deleteFlight(Long flightId);
}

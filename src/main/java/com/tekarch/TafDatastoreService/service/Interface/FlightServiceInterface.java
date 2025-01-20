package com.tekarch.TafDatastoreService.service.Interface;

import com.tekarch.TafDatastoreService.entities.Flights;
import com.tekarch.TafDatastoreService.model.FlightRequest;
import com.tekarch.TafDatastoreService.model.FlightResponse;

import java.util.List;

public interface FlightServiceInterface {

    List<FlightResponse> getFlights();
    FlightResponse getFlightById(Long flightId);
    FlightResponse saveFlight(FlightRequest flight);
    FlightResponse updateFlight(FlightRequest flights, Long flightId);
    void deleteFlight(Long flightId);
}

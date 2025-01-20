package com.tekarch.TafDatastoreService.model;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FlightRequest {

    private String flightNumber;
    private String departure;
    private String arrival;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private Integer price;
    private Integer availableSeats;
}

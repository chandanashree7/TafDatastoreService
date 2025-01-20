package com.tekarch.TafDatastoreService.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class FlightResponse implements Serializable {
    private Long id;
    private String flightNumber;
    private String departure;
    private String arrival;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private Integer price;
    private int availableSeats;
}

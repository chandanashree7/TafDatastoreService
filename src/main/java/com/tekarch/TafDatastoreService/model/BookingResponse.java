package com.tekarch.TafDatastoreService.model;

import com.tekarch.TafDatastoreService.entities.Flights;
import com.tekarch.TafDatastoreService.entities.Users;
import lombok.Data;

import java.io.Serializable;

@Data
public class BookingResponse implements Serializable {

    private UserResponse user;
    private FlightResponse flight;
    private String status;
    private Long bookingId;
}

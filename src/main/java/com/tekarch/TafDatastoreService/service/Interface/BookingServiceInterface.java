package com.tekarch.TafDatastoreService.service.Interface;


import com.tekarch.TafDatastoreService.entities.Bookings;
import com.tekarch.TafDatastoreService.entities.Flights;
import com.tekarch.TafDatastoreService.entities.Users;
import com.tekarch.TafDatastoreService.model.BookingDTO;

import java.util.List;
import java.util.Optional;

public interface BookingServiceInterface {

    Bookings saveBooking(BookingDTO booking);
    Bookings getBookingById(Long id);
    List<Bookings> getBookingByUserId(Long userId);

    //List<Bookings> getBookingsByUserId(String userId);

    Optional<Bookings> cancelBooking(Long bookingId);
}

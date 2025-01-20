package com.tekarch.TafDatastoreService.service.Interface;


import com.tekarch.TafDatastoreService.entities.Bookings;
import com.tekarch.TafDatastoreService.model.BookingRequest;
import com.tekarch.TafDatastoreService.model.BookingResponse;

import java.util.List;
import java.util.Optional;

public interface BookingServiceInterface {

    BookingResponse saveBooking(BookingRequest booking);
    BookingResponse getBookingById(Long id);
    List<BookingResponse> getBookingByUserId(Long userId);
    BookingResponse cancelBooking(Long bookingId);
}

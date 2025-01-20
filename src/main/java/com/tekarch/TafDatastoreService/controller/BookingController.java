package com.tekarch.TafDatastoreService.controller;



import com.tekarch.TafDatastoreService.entities.Bookings;


import com.tekarch.TafDatastoreService.model.BookingRequest;
import com.tekarch.TafDatastoreService.model.BookingResponse;
import com.tekarch.TafDatastoreService.service.BookingServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookingController {

    @Autowired
    private BookingServiceImpl bookingService;

    @PostMapping("/bookings")
    public ResponseEntity<BookingResponse> createBooking(@RequestBody BookingRequest booking) {
        BookingResponse createdBooking = bookingService.saveBooking(booking);
        System.out.println("Create booking: "+createdBooking);
        return new ResponseEntity<>(createdBooking, HttpStatus.CREATED);
    }

    @GetMapping("/bookings/{bookingId}")
    public ResponseEntity<BookingResponse> getBookingById(@PathVariable Long bookingId) {
        BookingResponse booking = bookingService.getBookingById(bookingId);
        return ResponseEntity.status(HttpStatus.OK).body(booking);
    }

    @GetMapping("/bookings/user/{userId}")
    public ResponseEntity<List<BookingResponse>> getBookingsByUserId(@PathVariable Long userId) {
        List<BookingResponse> booking = bookingService.getBookingByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(booking);
    }

    @DeleteMapping("/bookings/{bookingId}")
    public ResponseEntity<String> deleteBooking(@PathVariable Long bookingId) {
        BookingResponse booking = bookingService.cancelBooking(bookingId);
        return ResponseEntity.noContent().build();
    }
}

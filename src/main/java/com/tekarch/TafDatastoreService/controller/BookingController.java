package com.tekarch.TafDatastoreService.controller;



import com.tekarch.TafDatastoreService.entities.Bookings;


import com.tekarch.TafDatastoreService.entities.Flights;
import com.tekarch.TafDatastoreService.model.BookingDTO;
import com.tekarch.TafDatastoreService.service.BookingServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookingController {

    @Autowired
    private BookingServiceImpl bookingService;

    @PostMapping("/bookings")
    public ResponseEntity<Bookings> createBooking(@RequestBody BookingDTO booking) {
        Bookings createdBooking = bookingService.saveBooking(booking);
        return new ResponseEntity<>(createdBooking, HttpStatus.CREATED);
    }

    @GetMapping("/bookings/{bookingId}")
    public ResponseEntity<Bookings> getBookingById(@PathVariable Long bookingId) {
        Bookings booking = bookingService.getBookingById(bookingId);
        return ResponseEntity.status(HttpStatus.OK).body(booking);
    }

    @GetMapping("/bookings/user/{userId}")
    public ResponseEntity<List<Bookings>> getBookingsByUserId(@PathVariable Long userId) {
        List<Bookings> booking = bookingService.getBookingByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(booking);
    }

    @DeleteMapping("/bookings/{bookingId}")
    public ResponseEntity<String> deleteBooking(@PathVariable Long bookingId) {
        bookingService.cancelBooking(bookingId);
        return ResponseEntity.noContent().build();
    }
}

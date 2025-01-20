package com.tekarch.TafDatastoreService.service;

import com.tekarch.TafDatastoreService.entities.Bookings;
import com.tekarch.TafDatastoreService.entities.Flights;
import com.tekarch.TafDatastoreService.entities.Users;
import com.tekarch.TafDatastoreService.model.BookingDTO;
import com.tekarch.TafDatastoreService.repository.BookingRepository;
import com.tekarch.TafDatastoreService.service.Interface.BookingServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingServiceInterface {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Bookings saveBooking(BookingDTO bookingDTO) {
        Bookings booking=new Bookings();
        booking.setStatus(bookingDTO.getStatus());
        booking.setCreatedAt(LocalDateTime.now());

        Users user=new Users();
        user.setId(bookingDTO.getUserId());
        booking.setUser(user);

        Flights flight=new Flights();
        flight.setId(bookingDTO.getFlightId());
        booking.setFlight(flight);
        return bookingRepository.save(booking);
    }

    @Override
    public Bookings getBookingById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    @Override
    public List<Bookings> getBookingByUserId(Long userId) {
        return bookingRepository.findByUserId(userId);

    }

    @Override
    public Optional<Bookings> cancelBooking(Long bookingId) {
        Optional<Bookings> booking= bookingRepository.findById(bookingId);
        Bookings bookings = booking.get();
        bookings.setStatus("Cancelled");
        bookingRepository.save(bookings); // Save the updated booking
        return Optional.empty(); //Return empty if booking not found

    }
}

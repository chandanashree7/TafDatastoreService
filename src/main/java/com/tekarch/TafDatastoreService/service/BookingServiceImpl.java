package com.tekarch.TafDatastoreService.service;

import com.tekarch.TafDatastoreService.entities.Bookings;
import com.tekarch.TafDatastoreService.entities.Flights;
import com.tekarch.TafDatastoreService.entities.Users;
import com.tekarch.TafDatastoreService.model.BookingRequest;
import com.tekarch.TafDatastoreService.model.BookingResponse;
import com.tekarch.TafDatastoreService.model.FlightResponse;
import com.tekarch.TafDatastoreService.model.UserResponse;
import com.tekarch.TafDatastoreService.repository.BookingRepository;
import com.tekarch.TafDatastoreService.service.Interface.BookingServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingServiceInterface {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public BookingResponse saveBooking(BookingRequest request) {
        BookingResponse response = new BookingResponse();

        Bookings booking=new Bookings();
        booking.setStatus(request.getStatus());
        booking.setCreatedAt(LocalDateTime.now());

        Users user=new Users();
        user.setId(request.getUserId());
        booking.setUser(user);

        Flights flight=new Flights();
        flight.setId(request.getFlightId());
        booking.setFlight(flight);

        try {
            Bookings output = bookingRepository.save(booking);
            response = mapBookingData(output);
        } catch (Exception e) {
            System.out.println("Exception on Save booking:"+e.getMessage());
        }
        return response;
    }

    @Override
    public BookingResponse getBookingById(Long id) {
        Bookings output = bookingRepository.findById(id).orElse(null);
        assert output != null;
        return mapBookingData(output);
    }

    @Override
    public List<BookingResponse> getBookingByUserId(Long userId) {
        List<Bookings> bookings = bookingRepository.findByUserId(userId);
        List<BookingResponse> responses = new ArrayList<>();
        for (Bookings booking : bookings) {
            responses.add(mapBookingData(booking));
        }
        return responses;
    }

    @Override
    public BookingResponse cancelBooking(Long bookingId) {
        Optional<Bookings> booking= bookingRepository.findById(bookingId);
        Bookings bookings = booking.get();
        bookings.setStatus("Cancelled");
        Bookings output = bookingRepository.save(bookings); // Save the updated booking
        return mapBookingData(output); //Return empty if booking not found

    }

    private BookingResponse mapBookingData(Bookings output){
        BookingResponse response = new BookingResponse();
        if(output != null) {
            if (output.getFlight() != null) {
                response.setFlight(mapFlightDetails(output.getFlight()));
            }
            response.setStatus(output.getStatus());
            if (output.getUser() != null) {
                response.setUser(mapUserDetails(output.getUser()));
            }
            response.setBookingId(output.getId());
        }
        return response;
    }

    private FlightResponse mapFlightDetails(Flights flights){
        FlightResponse response = new FlightResponse();
        response.setId(flights.getId());
        response.setFlightNumber(flights.getFlightNumber());
        response.setDepartureTime(flights.getDepartureTime());
        response.setArrivalTime(flights.getArrivalTime());
        response.setArrival(flights.getArrival());
        response.setDeparture(flights.getDeparture());
        response.setAvailableSeats(flights.getAvailableSeats());
        return response;
    }

    private UserResponse mapUserDetails(Users users){
        UserResponse response = new UserResponse();
        response.setId(users.getId());
        response.setUserName(users.getUserName());
        response.setEmail(users.getEmail());
        response.setPhone(users.getPhone());

        return response;
    }
}

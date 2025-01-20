package com.tekarch.TafDatastoreService.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name="Flights")
public class Flights {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "flight_number", unique = true, nullable = false)
    private String flightNumber;

    @Column(nullable = false)
    private String departure;
    private String arrival;

    @Column(name = "departure_time", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime departureTime;

    @Column(name = "arrival_time", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime arrivalTime;

    @Column(nullable = false)
    private Integer price;

    @Column(name = "available_seats", nullable = false)
    private int availableSeats;

    @Column(name = "created_at", nullable = true)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = true)
    private LocalDateTime updatedAt;
}

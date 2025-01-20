package com.tekarch.TafDatastoreService.repository;


import com.tekarch.TafDatastoreService.entities.Flights;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flights,Long> {
}

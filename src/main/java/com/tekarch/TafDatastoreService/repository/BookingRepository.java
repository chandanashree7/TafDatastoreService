package com.tekarch.TafDatastoreService.repository;

import com.tekarch.TafDatastoreService.entities.Bookings;
import com.tekarch.TafDatastoreService.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Bookings,Long> {

    // Retrieve all bookings for a specific user by userId
    @Query(countQuery = "SELECT b FROM Bookings b WHERE b.user_id = :userId", nativeQuery = true)
    List<Bookings> findByUserId(@Param("userId") Long userId);


}

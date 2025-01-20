package com.tekarch.TafDatastoreService.repository;

import com.tekarch.TafDatastoreService.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {


}

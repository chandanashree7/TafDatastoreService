package com.tekarch.TafDatastoreService.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@Entity
@Data
@Table(name="Users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username", nullable = false, unique = true, length = 20)
    private String userName;
    private String email;
    @Column(name = "phone_number", length = 15)
    private String phone;
    @Column(name = "created_at" , nullable = true)
    private LocalDateTime createdAt;
    @Column(name = "updated_at" , nullable = true)
    private LocalDateTime updatedAt;
}

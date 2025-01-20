package com.tekarch.TafDatastoreService.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class UserResponse implements Serializable {
    private Long id;
    private String userName;
    private String email;
    private String phone;
}

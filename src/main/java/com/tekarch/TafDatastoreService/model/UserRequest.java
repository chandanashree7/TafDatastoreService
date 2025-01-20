package com.tekarch.TafDatastoreService.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRequest implements Serializable {

    private String userName;
    private String email;
    private String phone;
}

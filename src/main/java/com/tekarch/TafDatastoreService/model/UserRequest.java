package com.tekarch.TafDatastoreService.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRequest implements Serializable {

    private String userName;
    private String email;
    private String phone;
}

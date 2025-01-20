package com.tekarch.TafDatastoreService.model;

import lombok.Data;

@Data
public class BookingDTO {

    private Long userId;
    private Long flightId;
    private String status;

}

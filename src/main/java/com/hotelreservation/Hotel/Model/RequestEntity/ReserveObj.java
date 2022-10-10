package com.hotelreservation.Hotel.Model.RequestEntity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ReserveObj {

    private String email;
    private String mobile;
    private int roomno;
    private String lastname;
    private String firstname;
    private LocalDate checkin;
    private LocalDate checkout;

}

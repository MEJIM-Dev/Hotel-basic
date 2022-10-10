package com.hotelreservation.Hotel.Model.RequestEntity;

import com.hotelreservation.Hotel.Model.Reservation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReserveRes {
    private String email;
    private String mobile;
    private int roomno;
    private String lastname;
    private String firstname;
    private LocalDate checkin;
    private LocalDate checkout;
    private String transactionid;

    public void setReservationDetails(Reservation reservation) {
        this.checkin = reservation.getCheckin();
        this.checkout = reservation.getCheckOut();
        this.email = reservation.getEmail();
        this.mobile = reservation.getMobile();
        this.lastname = reservation.getLastname();
        this.transactionid = reservation.getTransactionId();
    }
}

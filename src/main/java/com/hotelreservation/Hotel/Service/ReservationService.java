package com.hotelreservation.Hotel.Service;

import com.hotelreservation.Hotel.Model.Reservation;
import com.hotelreservation.Hotel.Repostory.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    ReservationRepo reservationRepo;

    public List<Reservation> reservations(){
        return reservationRepo.findAll();
    }
}

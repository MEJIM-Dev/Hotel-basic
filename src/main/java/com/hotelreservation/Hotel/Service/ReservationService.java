package com.hotelreservation.Hotel.Service;

import com.hotelreservation.Hotel.Model.Reservation;
import com.hotelreservation.Hotel.Repostory.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    ReservationRepo reservationRepo;

    public List<Reservation> reservations(){
        return reservationRepo.findAll();
    }

    public ResponseEntity<?> cancelReservation(String transId){
        Optional<Reservation> byTransactionId = reservationRepo.findByTransactionId(transId);
        if(byTransactionId.isEmpty()){
            return ResponseEntity.badRequest().body("Invalid Reservation number");
        }
        reservationRepo.delete(byTransactionId.get());
        return ResponseEntity.ok().body(byTransactionId.get());
    }
}

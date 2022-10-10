package com.hotelreservation.Hotel.Repostory;

import com.hotelreservation.Hotel.Model.Reservation;
import com.hotelreservation.Hotel.Model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation, Long> {

    Optional<Reservation> findByCheckinAndRoomId(LocalDate checkin, long room);
    Optional<Reservation> findByTransactionId(String room);
}

package com.hotelreservation.Hotel.Repostory;

import com.hotelreservation.Hotel.Model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepo extends JpaRepository<Room,Long> {
    Room findByNumber(int roomno);

}

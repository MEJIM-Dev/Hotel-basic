package com.hotelreservation.Hotel.Service;

import com.hotelreservation.Hotel.Model.RequestEntity.ReserveObj;
import com.hotelreservation.Hotel.Model.RequestEntity.ReserveRes;
import com.hotelreservation.Hotel.Model.Reservation;
import com.hotelreservation.Hotel.Model.Room;
import com.hotelreservation.Hotel.Repostory.ReservationRepo;
import com.hotelreservation.Hotel.Repostory.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RoomService {

    @Autowired
    RoomRepo roomRepo;

    @Autowired
    ReservationRepo reservationRepo;

    public String saveRoom(Room room){

        System.out.println(roomRepo.save(room));
        return "save";
    }

    public List<Room> findRoom() {
        return roomRepo.findAll();
    }

    public ResponseEntity<?> reserveRoom(ReserveObj data, HttpServletResponse res) {
        Room room = roomRepo.findByNumber(data.getRoomno());
        if(data.getCheckin().compareTo(data.getCheckout()) != -1 ){
            res.setStatus(HttpStatus.BAD_REQUEST.value());
            return new ResponseEntity<>("Check out Date cannot be before or on the same Check in date", HttpStatus.BAD_REQUEST);
        }
        Optional<Reservation> optional = reservationRepo.findByCheckinAndRoomId(data.getCheckin(), room.getId());

        if(optional.isPresent()){
            System.out.println(optional.get());
            res.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
            return new ResponseEntity<>("room already booked for that day", HttpStatus.NOT_ACCEPTABLE) ;
        }

        if(!room.isAvailable()){
            res.setStatus(HttpStatus.CONFLICT.value());
            return new ResponseEntity<>("room already booked",HttpStatus.CONFLICT);
        }

        room.setAvailable(false);
        Reservation reservation = new Reservation(data, getTransId(transGen()),room, data);
        roomRepo.save(room);
        ReserveRes resObj = new ReserveRes();
        resObj.setReservationDetails(reservationRepo.save(reservation));
        res.setStatus(HttpStatus.CREATED.value());
        return new ResponseEntity<>(resObj,HttpStatus.CREATED);
    }

    public String getTransId(String id) {
        Optional<Reservation> res = reservationRepo.findByTransactionId(id);
        if(res.isPresent()){
            getTransId(transGen());
        }
        return id;
    }

    public String transGen(){
        return UUID.randomUUID().toString();
    }

    public void resetAllRooms(){
        List<Room> rooms = roomRepo.findAll();
        rooms.forEach(room -> {
            if(!room.isAvailable()){
                room.setAvailable(true);
                roomRepo.save(room);
            }
        });
        System.out.println("All rooms updated");
    }
}

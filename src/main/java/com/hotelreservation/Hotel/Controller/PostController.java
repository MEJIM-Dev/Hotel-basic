package com.hotelreservation.Hotel.Controller;

import com.hotelreservation.Hotel.Model.RequestEntity.ReserveObj;
import com.hotelreservation.Hotel.Model.Reservation;
import com.hotelreservation.Hotel.Model.Room;
import com.hotelreservation.Hotel.Service.ReservationService;
import com.hotelreservation.Hotel.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
public class PostController {
    @Autowired
    RoomService roomService;

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/available")
    public ResponseEntity<List<Room>> avail (){
        return ResponseEntity.ok(roomService.findRoom());
    }

    @PostMapping("/addroom")
    public String addRoom(@RequestBody() Room room){
        return roomService.saveRoom(room);
    }

    @PostMapping(value = "/reserve")
    public ResponseEntity<?> reserve (@RequestBody() ReserveObj data, HttpServletResponse res){
        return roomService.reserveRoom(data, res);
    }

    @GetMapping("/api/reservations")
    public List<Reservation> getReservation(){
        return reservationService.reservations();
    }

    @GetMapping("/api/rooms")
    public List<Room> Reservation(){
        return roomService.findRoom();
    }

    @PostMapping("api/checkout")
    public  ResponseEntity<?> checkout(@RequestBody String reference){
        return reservationService.cancelReservation(reference);
    }

}



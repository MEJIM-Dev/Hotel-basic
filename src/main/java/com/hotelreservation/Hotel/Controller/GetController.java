package com.hotelreservation.Hotel.Controller;

import com.hotelreservation.Hotel.Model.Reservation;
import com.hotelreservation.Hotel.Model.Room;
import com.hotelreservation.Hotel.Service.ReservationService;
import com.hotelreservation.Hotel.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class GetController {

    @GetMapping({"/","/home","/homepage","/index"})
    public String homepage(){
        return "homepage";
    }

    @GetMapping({"/available","/availablerooms"})
    public String bookRoom(){
        return "available";
    }

    @GetMapping("/room")
    public String room(){
        return "room";
    }

    @GetMapping("/reserve")
    public String reserveForm(@RequestParam("room") int roomNo, Model model){
        model.addAttribute("roomnumber", roomNo);
        return "book";
    }

    @GetMapping("/checkout")
    public String logoutForm(){
        return "checkout";
    }

}

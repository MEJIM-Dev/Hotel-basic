package com.hotelreservation.Hotel.Util;

import com.hotelreservation.Hotel.Service.RoomService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupTasks implements CommandLineRunner {

    private RoomService roomService;

    public StartupTasks(RoomService roomService){
        this.roomService = roomService;
    }

    @Override
    public void run(String... args) throws Exception{
        roomService.resetAllRooms();
    }
}

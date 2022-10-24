package com.hotelreservation.Hotel;

import com.hotelreservation.Hotel.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.regex.Pattern;

@SpringBootApplication
public class HotelApplication {
	@Autowired
	RoomService roomService;

	public static void main(String[] args) {
		SpringApplication.run(HotelApplication.class, args);
	}
}

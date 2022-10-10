package com.hotelreservation.Hotel.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private boolean available = true;

    @Column(nullable = false, unique = true)
    private int number;

    private int floor;

    private String information;

    private int price;

    private String currency;

}


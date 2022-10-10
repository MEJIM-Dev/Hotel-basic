package com.hotelreservation.Hotel.Model;

import com.hotelreservation.Hotel.Model.RequestEntity.ReserveObj;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity()
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "checkin")
    private LocalDate checkin;

    @Column(name = "checkout")
    private LocalDate checkOut;

    private int time= 12;

    @Column(name = "transactionid")
    private String transactionId;

    @OneToOne(targetEntity = Room.class)
    @JoinColumn(name = "roomid")
    private Room room;

    private String email;

    private String firstname;

    private String lastname;

    private String mobile;

    public Reservation(ReserveObj res, String transId, Room room, ReserveObj client){
        this.checkin= res.getCheckin();
        this.checkOut = res.getCheckout();
        this.room = room;
        this.transactionId = transId;
        this.email = client.getEmail();
        this.firstname = client.getFirstname();
        this.lastname = client.getLastname();
        this.mobile = client.getMobile();
    }

}

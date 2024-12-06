package com.bookings.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "seat_booking")
public class SeatBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "status", nullable = false)
    private Boolean status = false;

    @ManyToOne
    @JoinColumn(name = "seats_id")
    private Seats seats;

    @ManyToOne
    @JoinColumn(name = "fromStops_id")
    private Stops from;

    @ManyToOne
    @JoinColumn(name = "toStops_id")
    private Stops to;

    @ManyToOne
    @JoinColumn(name = "bus_id")
    private Bus bus;

}
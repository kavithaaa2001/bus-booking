package com.bookings.controller;

import com.bookings.entity.Seats;
import com.bookings.entity.StopsOrder;
import com.bookings.repository.SeatBookingRepository;
import com.bookings.repository.StopsOrderRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/seatBooking")
public class SeatBooking {

    private SeatBookingRepository seatBookingRepository;
    private StopsOrderRepository stopsOrderRepository;

    public SeatBooking(SeatBookingRepository seatBookingRepository, StopsOrderRepository stopsOrderRepository) {
        this.seatBookingRepository = seatBookingRepository;
        this.stopsOrderRepository = stopsOrderRepository;
    }

//    @PostMapping
//    public ResponseEntity<SeatBooking> addBooking(@RequestBody SeatBooking seatBooking){
//        SeatBooking save = seatBookingRepository.save(seatBooking);
//        return new ResponseEntity<>(save,HttpStatus.CREATED);
//    }
    @GetMapping
    public ResponseEntity<List<String>> getSeats(
            @RequestParam  String from,
            @RequestParam String to,
            @RequestParam long busId
            ){
        StopsOrder sourceOrder = stopsOrderRepository.searchOrder(from);
        StopsOrder destinationOrder = stopsOrderRepository.searchOrder(to);

        List<String> seats = seatBookingRepository.findBookedSeatsWithinRoute(busId, sourceOrder.getOrders(), destinationOrder.getOrders());
        return new ResponseEntity<>(seats, HttpStatus.OK);
    }
}

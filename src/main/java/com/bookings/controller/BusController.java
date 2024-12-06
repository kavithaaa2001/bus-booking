package com.bookings.controller;

import com.bookings.Service.BusService;
import com.bookings.entity.Bus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bus")
public class BusController {

    private BusService busService;

    public BusController(BusService busService) {
        this.busService = busService;
    }

//    @GetMapping
//    public ResponseEntity<List<Bus>> getBus(@RequestParam String from,
//                                            @RequestParam String to){
//        List<Bus> bus = busService.getBus(from, to);
//        return new ResponseEntity<>(bus, HttpStatus.CREATED);
//    }

}

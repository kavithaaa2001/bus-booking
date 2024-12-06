package com.bookings.Service;

import com.bookings.entity.Bus;
import com.bookings.repository.BusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusService {
    private BusRepository busRepository;

    public BusService(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

//    public List<Bus> getBus(String from,String to){
//        return busRepository.searchBus(from,to);
//    }
}

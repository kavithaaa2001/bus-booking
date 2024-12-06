package com.bookings.repository;

import com.bookings.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BusRepository extends JpaRepository<Bus, Long> {


    @Query("select b from Bus b " +
            "join StopsOrder so1 on so1.bus.id = b.id " +
            "join StopsOrder so2 on so2.bus.id = b.id " +
            "join StopsOrder so3 on so3.bus.id = b.id " +
            "join StopsOrder so4 on so4.bus.id = b.id " +
            "join Stops s1 on s1.id = so1.stops.id " +
            "join Stops s2 on s2.id = so2.stops.id " +
            "join Stops s3 on s3.id = so3.stops.id " +
            "join Stops s4 on s4.id = so4.stops.id " +
            "where s1.name = :from and s2.name = :to and so1.orders < so2.orders " +
            "and s3.name = :to and s4.name = :from and so3.orders < so4.orders and b.date =: date")
    List<Bus> searchBus(@Param("from") String from, @Param("to") String to,
                        @Param("date")LocalDate date);
}
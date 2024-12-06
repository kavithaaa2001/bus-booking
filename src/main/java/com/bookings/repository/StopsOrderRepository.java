package com.bookings.repository;

import com.bookings.entity.StopsOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StopsOrderRepository extends JpaRepository<StopsOrder, Long> {


    @Query("select so from StopsOrder so where so.stops.name = :name")
    StopsOrder searchOrder(@Param("name") String name);



}
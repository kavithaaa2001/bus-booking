package com.bookings.repository;

import com.bookings.entity.Seats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SeatsRepository extends JpaRepository<Seats, Long> {

}
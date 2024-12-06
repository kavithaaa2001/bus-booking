package com.bookings.repository;

import com.bookings.entity.SeatBooking;
import com.bookings.entity.Seats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SeatBookingRepository extends JpaRepository<SeatBooking, Long> {
    @Query("""
    SELECT s.name
    FROM SeatBooking sb
    JOIN sb.seats s
    JOIN s.bus b
    JOIN sb.from f
    JOIN sb.to t
    JOIN StopsOrder soFrom ON soFrom.stops.id = f.id AND soFrom.bus.id = b.id
    JOIN StopsOrder soTo ON soTo.stops.id = t.id AND soTo.bus.id = b.id
    WHERE b.id = :busId
      AND soFrom.orders < soTo.orders
      AND soFrom.orders >= :sourceOrder
      AND soTo.orders <= :destinationOrder
""")
    List<String> findBookedSeatsWithinRoute(
            @Param("busId") Long busId,
            @Param("sourceOrder") Integer sourceOrder,
            @Param("destinationOrder") Integer destinationOrder
    );


}
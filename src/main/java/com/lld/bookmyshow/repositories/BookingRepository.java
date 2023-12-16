package com.lld.bookmyshow.repositories;

import com.lld.bookmyshow.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}

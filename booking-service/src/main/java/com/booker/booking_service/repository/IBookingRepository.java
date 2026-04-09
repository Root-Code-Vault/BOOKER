package com.booker.booking_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booker.booking_service.dto.BookingDetailsResponseDto;
import com.booker.booking_service.entity.Booking;

public interface IBookingRepository extends JpaRepository<Booking, Long> {

	Booking findByIdAndUserId(Long id, Long userId);

	List<Booking> getByUserId(Long userId);
    
}

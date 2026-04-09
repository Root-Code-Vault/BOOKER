package com.booker.booking_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.booker.booking_service.dto.BookingDetailsResponseDto;
import com.booker.booking_service.dto.BookingRequestDto;
import com.booker.booking_service.dto.BookingResponseDto;

@Service
public interface IBookingService {
	public BookingResponseDto initiateBooking(BookingRequestDto dto);

	public List<BookingDetailsResponseDto> getBookingDetails(Long userId);

	// public Booking cancelBooking(Long id, Long userId);
}

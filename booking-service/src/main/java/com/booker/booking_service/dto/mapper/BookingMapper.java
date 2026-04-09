package com.booker.booking_service.dto.mapper;

import com.booker.booking_service.dto.BookingRequestDto;
import com.booker.booking_service.dto.BookingResponseDto;
import com.booker.booking_service.entity.Booking;

public class BookingMapper {

	public static Booking toEntity(BookingRequestDto dto) {
		Booking booking = new Booking();
		booking.setUserId(Long.valueOf(dto.getUserId()));
		booking.setProductId(Long.valueOf(dto.getProductId()));
		booking.setSeatId(Long.valueOf(dto.getSeatId()));
		booking.setStatus("INITIATED");
		return booking;
	}

	public static BookingResponseDto toDto(Booking entity) {
		BookingResponseDto dto = new BookingResponseDto();
		dto.setBookingId(entity.getId().toString());
		dto.setUserId(entity.getUserId().toString());
		dto.setProductId(entity.getProductId().toString());
		dto.setSeatId(entity.getSeatId().toString());
		dto.setPaymentId(entity.getPaymentId()==null?null:entity.getPaymentId().toString());
		dto.setStatus(entity.getStatus());
		return dto;
	}
}

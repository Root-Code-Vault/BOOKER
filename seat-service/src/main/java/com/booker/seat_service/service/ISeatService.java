package com.booker.seat_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.booker.seat_service.entity.Seat;

@Service
public interface ISeatService {

	List<Seat> getSeatsByProduct(Long productId);

	List<Seat> saveSeat(List<Seat> seat);

	Seat bookSeat(Long seatId);

	Seat releaseSeat(Long seatId);

	Seat getSeatById(Long id);

	

}

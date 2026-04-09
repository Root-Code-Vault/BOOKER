package com.booker.booking_service.client;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.booker.booking_service.dto.SeatResponseDto;

@FeignClient(name = "SEAT-SERVICE", contextId = "seatClient", configuration = com.booker.booking_service.config.FeignConfig.class)
public interface ISeatClient {
	@PutMapping("/seat/book/{seatId}")
	SeatResponseDto bookSeat(@PathVariable("seatId") String seatId);

	@PutMapping("/seat/release/{seatId}")
	void releaseSeat(@PathVariable("seatId") String seatId);

	@GetMapping("/seat/feign/{id}")
	@Cacheable(cacheNames = "seats", key = "#id")
	public SeatResponseDto getFeignSeatById(@PathVariable Long id);
}

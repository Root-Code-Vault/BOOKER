package com.booker.booking_service.service.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.booker.booking_service.client.IPaymentClient;
import com.booker.booking_service.entity.Booking;
import com.booker.booking_service.exception.ItemNotFoundException;
import com.booker.booking_service.repository.IBookingRepository;
import com.booker.events.BookSeat;

@Service
public class BookSeatKafkaEventConsumer {
	@Autowired
	private IBookingRepository bookingRepository;
	
	@Autowired
	private IPaymentClient client;

	@KafkaListener(topics = "booking-seat-response-event")
	public void consume(ConsumerRecord<String, BookSeat> event) {
		// System.out.println("!!! SEAT SERVICE RECEIVED EVENT: " + event.value());
		Booking booking = bookingRepository.findById(Long.valueOf(event.value().getBookingId().toString()))
				.orElseThrow(() -> new ItemNotFoundException(
						"Booking details not found for ID: " + event.value().getBookingId().toString()));

		if ("CONFIRMED".equalsIgnoreCase(event.value().getMessage().toString())) {
			booking.setStatus("CONFIRMED");
			booking.setPaymentId(Long.valueOf(client.getFeignPaymentByBookingId(booking.getId()).getId()));
			bookingRepository.save(booking);
		} else if ("FAILED".equalsIgnoreCase(event.value().getMessage().toString())) {
//			// throw seat already booked for user key
//			Map<String, String> error = new HashMap<String, String>();
//			error.put("userId", event.key());
//			error.put("seatId", event.value().getSeatId().toString());
//			error.put("productId", event.value().getProductId().toString());
//
//			throw new SeatAlreadyBookedException("SEAT_ALREADY_BOOKED", error);
			booking.setPaymentId(Long.valueOf(client.getFeignPaymentByBookingId(booking.getId()).getId()));
			booking.setStatus("FAILED");
			bookingRepository.save(booking);
		} else if ("FAILED-SEAT-ALREADY-BOOKED".equalsIgnoreCase(event.value().getMessage().toString())) {
			booking.setStatus("FAILED-SEAT-ALREADY-BOOKED");
			bookingRepository.save(booking);
		}
	}
}

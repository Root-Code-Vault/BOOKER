package com.booker.seat_service.service.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.booker.events.BookPayment;
import com.booker.events.BookSeat;
import com.booker.seat_service.entity.Seat;
import com.booker.seat_service.exception.SeatAlreadyBookedException;
import com.booker.seat_service.exception.SeatNotFoundException;
import com.booker.seat_service.repository.ISeatRepository;
import com.booker.seat_service.service.kafka.producer.BookPaymentKafkaEventProducer;
import com.booker.seat_service.service.kafka.producer.BookSeatKafkaEventProducer;

@Service
public class BookSeatKafkaEventConsumer {

	@Autowired
	private ISeatRepository seatRepository;

	@Autowired
	private BookPaymentKafkaEventProducer producer;
	
	@Autowired
	private BookSeatKafkaEventProducer seatProducer;

	@KafkaListener(topics = "booking-seat-event")
	public void consume(ConsumerRecord<String, BookSeat> event) {
		// System.out.println("!!! SEAT SERVICE RECEIVED EVENT: " + event.value());

		Seat seat = seatRepository.findById(Long.valueOf(event.value().getSeatId().toString()))
				.orElseThrow(() -> new SeatNotFoundException(Long.valueOf(event.value().getSeatId().toString())));

		if (("PENDING").equalsIgnoreCase(event.value().getMessage().toString())) {
			if (("OPEN").equalsIgnoreCase(seat.getStatus())) {
				seat.setStatus("PENDING");
				seatRepository.save(seat);

				BookPayment bookPayment = BookPayment.newBuilder().setBookingId(event.value().getBookingId())
						.setProductId(event.value().getProductId()).setSeatId(seat.getId().toString())
						.setMessage("START_PAYMENT").build();
				producer.produce(event.key(), bookPayment);
			} else {
				System.out.println("Seat " + seat.getId() + " is already " + seat.getStatus() + ". Sending FAILED event.");
				event.value().setMessage("FAILED-SEAT-ALREADY-BOOKED");
				seatProducer.produce(event.key(), event.value());
			}
			
		}

	}
}
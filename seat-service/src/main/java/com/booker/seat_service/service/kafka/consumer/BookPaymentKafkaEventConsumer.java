package com.booker.seat_service.service.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.booker.events.BookPayment;
import com.booker.events.BookSeat;
import com.booker.seat_service.entity.Seat;
import com.booker.seat_service.exception.SeatNotFoundException;
import com.booker.seat_service.repository.ISeatRepository;
import com.booker.seat_service.service.kafka.producer.BookSeatKafkaEventProducer;

@Service
public class BookPaymentKafkaEventConsumer {

	@Autowired
	private ISeatRepository iSeatRepository;

	@Autowired
	private BookSeatKafkaEventProducer producer;

	@KafkaListener(topics = "booking-payment-response-event")
	public void consume(ConsumerRecord<String, BookPayment> event) {
		Seat seat = iSeatRepository.findById(Long.valueOf(event.value().getSeatId().toString()))
				.orElseThrow(() -> new SeatNotFoundException(Long.valueOf(event.value().getSeatId().toString())));

		if ("CONFIRMED".equalsIgnoreCase(event.value().getMessage().toString())) {
			seat.setStatus("CONFIRMED");
			iSeatRepository.save(seat);

			BookSeat bookSeat = BookSeat.newBuilder().setBookingId(event.value().getBookingId()).setMessage("CONFIRMED")
					.setProductId(event.value().getProductId()).setSeatId(seat.getId().toString()).build();
			producer.produce(event.key(), bookSeat);
		} else if ("FAILED".equalsIgnoreCase(event.value().getMessage().toString())) {
			seat.setStatus("OPEN");
			iSeatRepository.save(seat);
			
			BookSeat bookSeat = BookSeat.newBuilder().setBookingId(event.value().getBookingId()).setMessage("FAILED")
					.setProductId(event.value().getProductId()).setSeatId(seat.getId().toString()).build();
			producer.produce(event.key(), bookSeat);
		}
	}

}

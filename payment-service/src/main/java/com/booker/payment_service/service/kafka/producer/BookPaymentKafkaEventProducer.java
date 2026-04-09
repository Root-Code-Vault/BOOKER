package com.booker.payment_service.service.kafka.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.booker.events.BookPayment;

@Service
public class BookPaymentKafkaEventProducer {

	private final KafkaTemplate<String, BookPayment> kafkaTemplate;
	
	public BookPaymentKafkaEventProducer(KafkaTemplate<String, BookPayment> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void produce(String key, BookPayment event) {
		kafkaTemplate.send("booking-payment-response-event", key, event);
	}
}

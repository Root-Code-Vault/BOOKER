package com.booker.booking_service.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {
	@Bean
	NewTopic createTopicBookSeat() {
		return new NewTopic("booking-seat-event", 3, (short) 1);
	}
	
	@Bean
	NewTopic createTopicBookingPayment() {
		return new NewTopic("booking-payment-event", 3, (short) 1);
	}
	
	@Bean
	NewTopic createTopicBookSeatResponse() {
		return new NewTopic("booking-seat-response-event", 3, (short) 1);
	}
	
	@Bean
	NewTopic createTopicBookingPaymentResponse() {
		return new NewTopic("booking-payment-response-event", 3, (short) 1);
	}
	
}

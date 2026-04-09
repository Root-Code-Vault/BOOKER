package com.booker.payment_service.dto.mapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import com.booker.payment_service.dto.PaymentRequestDto;
import com.booker.payment_service.dto.PaymentResponseDto;
import com.booker.payment_service.entity.Payment;

public class PaymentMapper {
	public static PaymentResponseDto toDto(Payment entity) {
		PaymentResponseDto dto = new PaymentResponseDto();
		dto.setAmount(entity.getAmount().toString());

		// Use DateTimeFormatter for LocalDateTime
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		dto.setCreatedAt(entity.getCreatedAt().format(formatter));

		dto.setId(entity.getId().toString());
		dto.setProductId(entity.getProductId().toString());
		dto.setStatus(entity.getStatus());
		dto.setTransactionId(entity.getTransactionId());
		dto.setUserId(entity.getUserId().toString());

		return dto;
	}

	public static Payment toEntity(PaymentRequestDto dto) {
		Payment entity = new Payment();
		entity.setAmount(Double.valueOf(dto.getAmount()));
		entity.setCreatedAt(LocalDateTime.now());
		entity.setProductId(Long.valueOf(dto.getProductId()));
		entity.setStatus("PENDING");
		entity.setTransactionId(UUID.randomUUID().toString());
		entity.setUserId(Long.valueOf(dto.getUserId()));

		return entity;
	}
}

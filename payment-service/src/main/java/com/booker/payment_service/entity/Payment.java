package com.booker.payment_service.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "BKR_PAYMENT_MST")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PAYMENT_ID", nullable = false, unique = true)
	private Long id;

	@Column(name = "PAYMENT_USER_ID", nullable = false, unique = false)
	private Long userId; // who made the payment

	@Column(name = "PAYMENT_PRODUCT_ID", nullable = false, unique = false)
	private Long productId; // movie/ticket being purchased
	
	@Column(name = "PAYMENT_SEAT_ID", nullable = false, unique = false)
	private Long seatId;
	
	@Column(name = "PAYMENT_BOOKING_ID", nullable = false, unique = true)
	private Long bookingId;

	@Column(name = "PAYMENT_AMOUNT", nullable = false, unique = false)
	private Double amount; // payment amount

	@Column(name = "PAYMENT_STATUS", nullable = false, unique = false)
	private String status; // PENDING, SUCCESS, FAILED

	@Column(name = "PAYMENT_TRANSACTION_ID", nullable = false, unique = true)
	private String transactionId; // external reference

	@Column(name = "PAYMENT_TRANSACTION_TIME", nullable = false, unique = false)
	private LocalDateTime createdAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public Long getSeatId() {
		return seatId;
	}

	public void setSeatId(Long seatId) {
		this.seatId = seatId;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}
}

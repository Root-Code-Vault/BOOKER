package com.booker.booking_service.dto;

public class BookingRequestDto {
	private String userId;
	private String productId;
	private String seatId;
	//private String amount;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getSeatId() {
		return seatId;
	}

	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}

	/*
	 * public String getAmount() { return amount; }
	 * 
	 * public void setAmount(String amount) { this.amount = amount; }
	 */

}
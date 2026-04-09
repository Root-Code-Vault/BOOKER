package com.booker.booking_service.dto;

public class BookingDetailsResponseDto {
	private String bookingId, seatNumber, ticketCost, transactionTime, transactionId, productTitle, productGenre,
			productLanguage, productDescription, productShowDate, productShowTime, productVenue, status;

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getTicketCost() {
		return ticketCost;
	}

	public void setTicketCost(String ticketCost) {
		this.ticketCost = ticketCost;
	}

	public String getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(String transactionTime) {
		this.transactionTime = transactionTime;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public String getProductGenre() {
		return productGenre;
	}

	public void setProductGenre(String productGenre) {
		this.productGenre = productGenre;
	}

	public String getProductLanguage() {
		return productLanguage;
	}

	public void setProductLanguage(String productLanguage) {
		this.productLanguage = productLanguage;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductShowDate() {
		return productShowDate;
	}

	public void setProductShowDate(String productShowDate) {
		this.productShowDate = productShowDate;
	}

	public String getProductShowTime() {
		return productShowTime;
	}

	public void setProductShowTime(String productShowTime) {
		this.productShowTime = productShowTime;
	}

	public String getProductVenue() {
		return productVenue;
	}

	public void setProductVenue(String productVenue) {
		this.productVenue = productVenue;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}

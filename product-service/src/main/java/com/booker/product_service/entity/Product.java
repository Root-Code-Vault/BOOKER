package com.booker.product_service.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "BKR_PRODUCT_MST")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PROD_ID")
	private Long id;

	@Column(name = "PROD_TITLE", nullable = false, unique = false)
	private String title;

	@Column(name = "PROD_GENRE", nullable = false, unique = false)
	private String genre;

	@Column(name = "PROD_LANGUAGE", nullable = false, unique = false)
	private String language;

	@Column(name = "PROD_DESC", nullable = true, unique = false)
	private String description;

	@Column(name = "PROD_PRICE", nullable = false, unique = false)
	private Double price;

	@Column(name = "PROD_DATE", nullable = false, unique = false)
	private Date showDate;

	@Column(name = "PROD_TIME", nullable = false, unique = false)
	private String showTime;

	@Column(name = "PROD_VENUE", nullable = false, unique = false)
	private String venue;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getShowDate() {
		return showDate;
	}

	public void setShowDate(Date showDate) {
		this.showDate = showDate;
	}

	public String getShowTime() {
		return showTime;
	}

	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}
}

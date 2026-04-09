package com.booker.product_service.dto.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.booker.product_service.dto.ProductRequestDto;
import com.booker.product_service.dto.ProductResponseDto;
import com.booker.product_service.entity.Product;

public class ProductMapper {
	public static Product toEntity(ProductRequestDto dto) {
		Product product = new Product();
		product.setDescription(dto.getDescription());
		product.setGenre(dto.getGenre());
		product.setLanguage(dto.getLanguage());
		product.setPrice(Double.valueOf(dto.getPrice()));
		product.setShowTime(dto.getShowTime());
		try {
			product.setShowDate(new SimpleDateFormat("dd-MM-yyyy").parse(dto.getShowDate()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		product.setTitle(dto.getTitle());
		product.setVenue(dto.getVenue());
		
		return product;
	}
	
	public static ProductResponseDto toDto(Product product) {
		ProductResponseDto dto = new ProductResponseDto();
		dto.setId(product.getId().toString());
		dto.setDescription(product.getDescription());
		dto.setGenre(product.getGenre());
		dto.setLanguage(product.getLanguage());
		dto.setPrice(product.getPrice().toString());
		dto.setShowDate(new SimpleDateFormat("dd-MM-yyyy").format(product.getShowDate()));
		dto.setShowTime(product.getShowTime());
		dto.setTitle(product.getTitle());
		dto.setVenue(product.getVenue());
		
		return dto;
	}
}

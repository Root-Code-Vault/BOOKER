package com.booker.payment_service.service.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.booker.payment_service.dto.ProductResponseDto;

@FeignClient(name = "PRODUCT-SERVICE", configuration = com.booker.payment_service.config.FeignConfig.class)
public interface IProductServiceClient {
	@GetMapping("/product/{id}")
	ProductResponseDto getProduct(@PathVariable("id") String productId);
}

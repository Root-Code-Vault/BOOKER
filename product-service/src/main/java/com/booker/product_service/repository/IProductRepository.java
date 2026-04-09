package com.booker.product_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booker.product_service.entity.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

}

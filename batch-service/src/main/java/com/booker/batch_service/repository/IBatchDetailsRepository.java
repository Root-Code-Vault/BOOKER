package com.booker.batch_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booker.batch_service.entity.BatchDetails;

public interface IBatchDetailsRepository extends JpaRepository<BatchDetails, Long> {

}

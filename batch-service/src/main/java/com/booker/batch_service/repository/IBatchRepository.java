package com.booker.batch_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booker.batch_service.entity.Batch;

@Repository
public interface IBatchRepository extends JpaRepository<Batch, Long> {

	Batch findByBatchName(String batchName);

}

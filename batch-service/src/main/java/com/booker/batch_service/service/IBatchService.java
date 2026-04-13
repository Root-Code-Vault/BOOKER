package com.booker.batch_service.service;

import org.springframework.stereotype.Service;

import com.booker.batch_service.entity.Batch;

@Service
public interface IBatchService {
	public Batch loadBatchDetails(String batchName);
}

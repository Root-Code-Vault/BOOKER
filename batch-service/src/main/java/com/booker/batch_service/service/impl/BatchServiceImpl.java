package com.booker.batch_service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.booker.batch_service.entity.Batch;
import com.booker.batch_service.repository.IBatchRepository;
import com.booker.batch_service.service.IBatchService;

public class BatchServiceImpl implements IBatchService {
	@Autowired
    private IBatchRepository batchRepository;

	@Override
	public Batch loadBatchDetails(String batchName) {
		return batchRepository.findByBatchName(batchName);
	}
}

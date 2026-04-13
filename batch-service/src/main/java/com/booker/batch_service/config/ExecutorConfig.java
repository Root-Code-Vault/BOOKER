package com.booker.batch_service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.booker.batch_service.entity.Batch;
import com.booker.batch_service.entity.BatchDetails;
import com.booker.batch_service.service.IBatchService;

@Configuration
public class ExecutorConfig {
	@Autowired
	private IBatchService batchService;

	@Bean
	TaskExecutor dynamicExecutor(@Value("#{jobParameters['batchName']}") String batchName) {
		Batch batch = batchService.loadBatchDetails(batchName);
		BatchDetails details = batch.getBatchDetails();

		if (Boolean.FALSE.equals(batch.getMultithreaded())) {
			return new SyncTaskExecutor();
		}

		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(details.getCorePoolSize());
		executor.setMaxPoolSize(details.getMaxPoolSize());
		executor.setKeepAliveSeconds(details.getKeepAliveSeconds());
		executor.setThreadNamePrefix(batchName + "-thread-");
		executor.initialize();

		return executor;
	}
}

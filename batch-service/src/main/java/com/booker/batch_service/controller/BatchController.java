package com.booker.batch_service.controller;

import java.time.LocalDateTime;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.NoSuchJobException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/batch")
public class BatchController {
	
	@Autowired
	private JobLauncher jobLauncher;
	
	@Autowired
    private JobRegistry jobRegistry;

	@PostMapping("/run")
    public ResponseEntity<String> runJob(@RequestParam String batchName, 
                                         @RequestParam String filePath) {
        try {
            JobParameters params = new JobParametersBuilder()
                    .addString("filePath", filePath)
                    .addLocalDateTime("timestamp", LocalDateTime.now())
                    .toJobParameters();

            // Dynamically find the job by name (importProductJob, importSeatJob, etc.)
            Job job = jobRegistry.getJob(batchName);
            jobLauncher.run(job, params);

            return ResponseEntity.ok("Job " + batchName + " started successfully.");
        } catch (NoSuchJobException e) {
            return ResponseEntity.status(404).body("Job not found: " + batchName);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }
}

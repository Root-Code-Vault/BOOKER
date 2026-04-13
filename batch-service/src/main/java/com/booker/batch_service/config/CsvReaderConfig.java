package com.booker.batch_service.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class CsvReaderConfig {
	@Bean
	FlatFileItemReader<Map<String, String>> dynamicCsvReader(@Value("#{jobParameters['csvFile']}") String csvFile) {

		return new FlatFileItemReaderBuilder<Map<String, String>>().name("dynamicCsvReader")
				.resource(new FileSystemResource(csvFile)).lineMapper((line, lineNumber) -> {
					String[] tokens = line.split(",");
					Map<String, String> map = new LinkedHashMap<>();
					for (int i = 0; i < tokens.length; i++) {
						map.put("col" + i, tokens[i]);
					}
					return map;
				}).build();
	}
}

package com.booker.batch_service.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "BKR_BATCH_MST")
public class Batch {
	@Id
	@Column(name = "BTACH_ID", unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "BATCH_NAME", unique = true)
	private String batchName;

	@Column(name = "BATCH_DESC")
	private String batchDescription;

	@Column(name = "BATCH_PARALLEL")
	private Boolean multithreaded;

	@OneToOne(mappedBy = "batchId", orphanRemoval = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private BatchDetails batchDetails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public String getBatchDescription() {
		return batchDescription;
	}

	public void setBatchDescription(String batchDescription) {
		this.batchDescription = batchDescription;
	}

	public Boolean getMultithreaded() {
		return multithreaded;
	}

	public void setMultithreaded(Boolean multithreaded) {
		this.multithreaded = multithreaded;
	}

	public BatchDetails getBatchDetails() {
		return batchDetails;
	}

	public void setBatchDetails(BatchDetails batchDetails) {
		this.batchDetails = batchDetails;
	}

}

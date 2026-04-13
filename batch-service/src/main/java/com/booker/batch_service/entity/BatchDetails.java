package com.booker.batch_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "BKR_BATCH_CONFIG")
public class BatchDetails {
	@Id
	@Column(name = "BATCH_CONF_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BTACH_ID", nullable = false)
	private Batch batch;

	@Column(name = "BATCH_CONF_CORE_POOL")
	private Integer corePoolSize;

	@Column(name = "BATCH_CONF_MAX_POOL")
	private Integer maxPoolSize;

	@Column(name = "BATCH_CONF_ALIVE_TIME")
	private Integer keepAliveSeconds;

	@Column(name = "BATCH_CONF_CHUNK_SIZE")
	private Integer chunkSize;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	public Integer getCorePoolSize() {
		return corePoolSize;
	}

	public void setCorePoolSize(Integer corePoolSize) {
		this.corePoolSize = corePoolSize;
	}

	public Integer getMaxPoolSize() {
		return maxPoolSize;
	}

	public void setMaxPoolSize(Integer maxPoolSize) {
		this.maxPoolSize = maxPoolSize;
	}

	public Integer getKeepAliveSeconds() {
		return keepAliveSeconds;
	}

	public void setKeepAliveSeconds(Integer keepAliveSeconds) {
		this.keepAliveSeconds = keepAliveSeconds;
	}

	public Integer getChunkSize() {
		return chunkSize;
	}

	public void setChunkSize(Integer chunkSize) {
		this.chunkSize = chunkSize;
	}

}

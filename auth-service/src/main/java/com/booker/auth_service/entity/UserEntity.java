package com.booker.auth_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "BKR_USER_MST")
public class UserEntity {
	@Id
	@Column(name = "USR_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_ID_SEQ_GEN")
	@SequenceGenerator(name = "USER_ID_SEQ_GEN", sequenceName = "USER_ID_SEQ_GEN", initialValue = 1, allocationSize = 1)
	private Long id;

	@Column(name = "USR_NAME", nullable = false)
	private String name;

	@Column(name = "USR_EMAIL", nullable = false, unique = true)
	@Email
	private String email;

	@Column(name = "USR_PASSWORD", nullable = false, unique = false)
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

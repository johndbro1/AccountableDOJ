package com.undefined.doj.accountable.repository;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "USER")
public class User extends AbstractPersistable<Long> implements Serializable {

	
	@Column(name = "CREATE_DT", nullable = false, updatable = false)
	@JsonIgnore
	private Long createDate;
	
	@Column(name = "USERNAME", nullable = false)
	private String username;
		
	@Enumerated(EnumType.STRING)
	private UserType userType;
	
	
	@Column(name = "LOCKED", nullable = false)
	@JsonIgnore
	private boolean locked;

	@Column(name = "DISABLED", nullable = false)
	@JsonIgnore
	private boolean disabled;
	
	@OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ApiKey> apiKeys = new ArrayList<>();
	
	
	@OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)
	private List<UserRole> roles = new ArrayList<>();
	
	@PrePersist
	void createDate() {
		this.createDate = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
	}

	
	
}

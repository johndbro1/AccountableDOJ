package com.undefined.doj.accountable.repository;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneOffset;


import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name="API_KEY")
public class ApiKey extends AbstractPersistable<Long> implements Serializable {

	@ManyToOne
	@JoinColumn(name="USER_ID")
	@JsonManagedReference
	private User user;

	@Column(name="CREATE_DT", nullable=false)
	private Long createDate;
	
	@Column(name="EXPIRES_DT", nullable=false)
	private Long expireDate;
	
	
	@Column(name="ACCESS_KEY", nullable=false, length=512)
	private String accessKey;
	
	
	@Column(name="SECRET_KEY", nullable=false, length=512)
	private String secretKey;
	
	@PrePersist
	void createDate() {
		this.createDate = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
	}
	
}

package com.undefined.doj.accountable.repository;

import java.io.Serializable;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "DOCUMENT")
public class Document extends AbstractPersistable<Long> implements Serializable {

	@Column(name="TITLE", nullable=false, length=1024)
	private String title;

	@Column(name="VERSION_NUMBER", nullable=true, length=128)
	private String versionNumber;

	@Column(name = "LATEST", nullable = false)
	private boolean latest;

	
	@Column(name="STORAGE_LOCATION", nullable=false, length=1024)
	private String storageLocation;
	
	
	@Enumerated(EnumType.STRING)
	private StorageType storageType;
	

	
	@Column(name = "CREATE_DT", nullable = false, updatable = false)
	@JsonIgnore
	private Long createDate;
	
	@Column(name = "CREATED_BY", nullable = false, updatable = false)
	@JsonIgnore
	private User user;

	@Column(name = "ACTIVE", nullable = false)
	private boolean active;

}

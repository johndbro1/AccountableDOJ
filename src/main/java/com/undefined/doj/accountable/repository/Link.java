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
@Table(name = "LINK")
public class Link extends AbstractPersistable<Long> implements Serializable {

	@Column(name = "CREATE_DT", nullable = false, updatable = false)
	@JsonIgnore
	private Long createDate;
	
	@Column(name = "CREATED_BY", nullable = false, updatable = false)
	@JsonIgnore
	private User user;
	
	
	@Column(name="LOCATION", nullable=false, length=1024)
	private String location;
	
	
	@Enumerated(EnumType.STRING)
	private LinkType linkType;

	@Column(name = "ACTIVE", nullable = false)
	private boolean active;

}

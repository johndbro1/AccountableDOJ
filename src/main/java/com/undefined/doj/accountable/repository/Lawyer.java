package com.undefined.doj.accountable.repository;

import java.io.Serializable;
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
import jakarta.persistence.Table;

@Entity
@Table(name = "LAWYER")
public class Lawyer extends AbstractPersistable<Long> implements Serializable {
	
	@Column(name="NAME", nullable=true, length=256)
	private String name;
	
	
	@Column(name="DESCRIPTION", nullable=true, length=2048)
	private String description;
	

	@Enumerated(EnumType.STRING)
	private LawyerStatus status;
	
	@Enumerated(EnumType.STRING)
	private LawyerMembership membership;
	
	
	@Column(name = "CREATE_DT", nullable = false, updatable = false)
	@JsonIgnore
	private Long createDate;
	
	@Column(name = "CREATED_BY", nullable = false, updatable = false)
	@JsonIgnore
	private User user;

	@Column(name = "ACTIVE", nullable = false)
	private boolean active;
	
	
	@OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)
	private List<LawyerIdentifier> identifiers = new ArrayList<>();
	
	
	@OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)
	private List<LawyerNote> notes = new ArrayList<>();
	
	
}

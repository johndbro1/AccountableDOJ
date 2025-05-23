package com.undefined.doj.accountable.repository;

import java.io.Serializable;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CASE_LAWYER")
public class CaseLawyer extends AbstractPersistable<Long> implements Serializable {

	
	@ManyToOne
	@JoinColumn(name="CASE_ID")
	@JsonManagedReference
	private Case courtCase;
	
	@ManyToOne
	@JoinColumn(name="LAWYER_ID")
	@JsonManagedReference
	private Lawyer lawyer;
	

	@Enumerated(EnumType.STRING)
	private RepresentationType type;
	
	@Column(name = "CREATE_DT", nullable = false, updatable = false)
	@JsonIgnore
	private Long createDate;
	
	@Column(name = "CREATED_BY", nullable = false, updatable = false)
	@JsonIgnore
	private User user;

	@Column(name = "ACTIVE", nullable = false)
	private boolean active;
	
}

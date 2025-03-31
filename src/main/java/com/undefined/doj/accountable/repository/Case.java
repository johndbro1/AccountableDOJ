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
@Table(name = "CASE")
public class Case extends AbstractPersistable<Long> implements Serializable {
	
	@Column(name="NUMBER", nullable=true, length=128)
	private String number;
	
	@Column(name="COURT", nullable=true, length=512)
	private String court;
	
	@Column(name="JUDGE", nullable=true, length=256)
	private String judge;

	
	@Column(name="TITLE", nullable=true, length=1024)
	private String title;
	
	
	@Column(name="PACER_CASE_ID", nullable=true, length=512)
	private String pacerCaseIdentifier;
	

	@Enumerated(EnumType.STRING)
	private CaseStatus status;
	
	
	@Enumerated(EnumType.STRING)
	private CaseType type;
	
	
	@Column(name = "FILED_DT", nullable = true, updatable = true)
	private Long filedDate;

	
	@Column(name = "CREATE_DT", nullable = false, updatable = false)
	@JsonIgnore
	private Long createDate;
	
	@Column(name = "CREATED_BY", nullable = false, updatable = false)
	@JsonIgnore
	private User user;

	@Column(name = "ACTIVE", nullable = false)
	private boolean active;
	
	
	@OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Pleading> pleadings = new ArrayList<>();
	
	
	@OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CaseLawyer> lawyers = new ArrayList<>();
	
}

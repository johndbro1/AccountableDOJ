package com.undefined.doj.accountable.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "PLEADING")
public class Pleading extends AbstractPersistable<Long> implements Serializable {
	
	@ManyToOne
	@JoinColumn(name="CASE_ID")
	@JsonManagedReference
	private Case courtCase;

	@ManyToOne
	@JoinColumn(name="CASE_LAWYER_ID")
	@JsonManagedReference
	private CaseLawyer caseLawyer;
	
	@Column(name="DESCRIPTION", nullable=true, length=2048)
	private String description;
	
	
	@Column(name="PACER_PLEADING_ID", nullable=true, length=512)
	private String pacerPleadingIdentifier;

	@Column(name = "CREATE_DT", nullable = false, updatable = false)
	@JsonIgnore
	private Long createDate;
	
	@Column(name = "CREATED_BY", nullable = false, updatable = false)
	@JsonIgnore
	private User user;

	@Column(name = "ACTIVE", nullable = false)
	private boolean active;

	@OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PleadingComment> comments = new ArrayList<>();

	@OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PleadingDocument> documents = new ArrayList<>();
	
	@OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PleadingLink> links = new ArrayList<>();
	
	
}

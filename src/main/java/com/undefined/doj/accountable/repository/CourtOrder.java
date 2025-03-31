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
@Table(name = "COURT_ORDER")
public class CourtOrder extends AbstractPersistable<Long> implements Serializable {

	
	@ManyToOne
	@JoinColumn(name="CASE_ID")
	@JsonManagedReference
	private Case courtCase;

	@ManyToOne
	@JoinColumn(name="PLEADING_ID")
	@JsonManagedReference
	private Pleading pleading;
	
	@Column(name="JUDGE", nullable=true, length=256)
	private String judge;

	
	@Column(name="IDENTIFIER", nullable=true, length=1024)
	private String identifier;
	
	
	@Column(name = "CREATE_DT", nullable = false, updatable = false)
	@JsonIgnore
	private Long createDate;
	
	@Column(name = "CREATED_BY", nullable = false, updatable = false)
	@JsonIgnore
	private User user;

	@Column(name = "ACTIVE", nullable = false)
	private boolean active;
	
	@OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CourtOrderComment> comments = new ArrayList<>();
	
	@OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CourtOrderDocument> documents = new ArrayList<>();
	
	@OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CourtOrderLink> links = new ArrayList<>();
	
}

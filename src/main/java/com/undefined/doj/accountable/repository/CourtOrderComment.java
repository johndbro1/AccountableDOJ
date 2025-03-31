package com.undefined.doj.accountable.repository;

import java.io.Serializable;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "COURT_ORDER_COMMENT")
public class CourtOrderComment extends AbstractPersistable<Long> implements Serializable {

	@ManyToOne
	@JoinColumn(name="COURT_ORDER_ID")
	@JsonManagedReference
	private CourtOrder courtOrder;
	
	
	@ManyToOne
	@JoinColumn(name="COMMENT_ID")
	@JsonManagedReference
	private Comment comment;
	
}

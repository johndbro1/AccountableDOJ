package com.undefined.doj.accountable.repository;

import java.io.Serializable;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PLEADING_COMMENT")
public class PleadingComment extends AbstractPersistable<Long> implements Serializable {

	@ManyToOne
	@JoinColumn(name="PLEADING_ID")
	@JsonManagedReference
	private Pleading pleading;
	
	
	@ManyToOne
	@JoinColumn(name="COMMENT_ID")
	@JsonManagedReference
	private Comment comment;

}

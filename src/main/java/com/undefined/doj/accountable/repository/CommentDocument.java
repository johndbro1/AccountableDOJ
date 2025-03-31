package com.undefined.doj.accountable.repository;

import java.io.Serializable;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "COMMENT_DOCUMENT")
public class CommentDocument extends AbstractPersistable<Long> implements Serializable {

	
	@ManyToOne
	@JoinColumn(name="COMMENT_ID")
	@JsonManagedReference
	private Comment comment;
	
	
	@ManyToOne
	@JoinColumn(name="DOCUMENT_ID")
	@JsonManagedReference
	private Document document;

	
}

package com.undefined.doj.accountable.repository;

import java.io.Serializable;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "USER_ROLE")
public class UserRole extends AbstractPersistable<Long> implements Serializable {

	@ManyToOne
	@JoinColumn(name="USER_ID")
	@JsonManagedReference
	private User user;
	
	
	@ManyToOne
	@JoinColumn(name="ROLE_ID")
	@JsonManagedReference
	private Role role;
	
	
}

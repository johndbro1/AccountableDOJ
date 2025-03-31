package com.undefined.doj.accountable.repository;

import java.io.Serializable;

import org.springframework.data.jpa.domain.AbstractPersistable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "role")
public class Role extends AbstractPersistable<Long> implements Serializable {

	@Column(name="role", nullable=false)
	private String role;
	
	
	@Column(name="description")
	private String description;
	
}

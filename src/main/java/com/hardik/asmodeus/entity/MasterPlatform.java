package com.hardik.asmodeus.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Setter;

import lombok.Getter;

@Entity
@Table(name = "master_platforms")
@Getter
@Setter
public class MasterPlatform implements Serializable {

	private static final long serialVersionUID = -7483799371153663251L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true, insertable = false, updatable = false)
	private Integer id;

	@Column(name = "name", nullable = false, unique = true)
	private String name;
	
}

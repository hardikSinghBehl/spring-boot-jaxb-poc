package com.hardik.asmodeus.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode.Exclude;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "streamers")
@Getter
@Setter
public class Streamer implements Serializable {

	private static final long serialVersionUID = -5061554507530946641L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true, insertable = false, updatable = false)
	private UUID id;

	@Column(name = "full_name", nullable = false)
	private String fullName;

	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;
	
	@Column(name = "country_id", nullable = false)
	private Integer countryId;
	
	@Exclude
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "country_id", nullable = false, insertable = false, updatable = false)
	private MasterCountry masterCountry;
	
	@Column(name = "platform_id", nullable = false)
	private Integer platformId;
	
	@Exclude
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "platform_id", nullable = false, insertable = false, updatable = false)
	private MasterPlatform masterPlatform;
		
	@Column(name = "created_at", nullable = false, insertable = false, updatable = false)
	private LocalDateTime createdAt;
	
	@Column(name = "updated_at", nullable = false, insertable = false, updatable = false)
	private LocalDateTime updatedAt;

}

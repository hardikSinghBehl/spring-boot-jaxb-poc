package com.hardik.asmodeus.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hardik.asmodeus.entity.MasterCountry;

@Repository
public interface MasterCountryRepository extends JpaRepository<MasterCountry, Integer>{

	Optional<MasterCountry> findByIsoCode(String isoCode);
}


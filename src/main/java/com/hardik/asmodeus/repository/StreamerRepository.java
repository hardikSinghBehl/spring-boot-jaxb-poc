package com.hardik.asmodeus.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hardik.asmodeus.entity.Streamer;

@Repository
public interface StreamerRepository extends JpaRepository<Streamer, UUID> {

	Optional<Streamer> findByFullNameAndDateOfBirth(String fullName, LocalDate localDate);
	
	List<Streamer> findByMasterPlatformName(String masterPlatform);

}

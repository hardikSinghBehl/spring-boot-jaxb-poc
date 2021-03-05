package com.hardik.asmodeus.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hardik.asmodeus.entity.MasterPlatform;

@Repository
public interface MasterPlatformRepository extends JpaRepository<MasterPlatform, Integer>{
	
	Optional<MasterPlatform> findByNameIgnoreCase(String name);

}

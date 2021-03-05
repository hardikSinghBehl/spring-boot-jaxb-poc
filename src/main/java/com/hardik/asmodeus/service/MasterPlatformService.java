package com.hardik.asmodeus.service;

import org.springframework.stereotype.Service;

import com.hardik.asmodeus.repository.MasterPlatformRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MasterPlatformService {
	
	private final MasterPlatformRepository masterPlatformRepository;

}

package com.hardik.asmodeus.service;

import org.springframework.stereotype.Service;

import com.hardik.asmodeus.repository.MasterCountryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MasterCountryService {
	
	private final MasterCountryRepository masterCountryRepository;

}

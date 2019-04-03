package com.lexisnexis.PlanetDatabase.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lexisnexis.PlanetDatabase.Repository.PlanetDataRepository;
import com.lexisnexis.PlanetDatabase.model.Planet;

@Service
public class PlanetDatabaseAppService {
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(PlanetDatabaseAppService.class);

	@Autowired
	private PlanetDataRepository planetDataRepository;
	
	public List<Planet> getAllPlanets(){
		List<Planet> planets =new ArrayList<Planet>();		
		planetDataRepository.findAll().forEach(planets::add);
		if(planets !=null) {
	    	logger.info("Planet List Size "+planets.size());
		}
		return planets;
	}
	
	public void addPlanets(List<Planet> planets) {		
		planetDataRepository.saveAll(planets);
	}
	
}

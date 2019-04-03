package com.lexisnexis.PlanetDatabase.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lexisnexis.PlanetDatabase.Repository.PlanetDataRepository;
import com.lexisnexis.PlanetDatabase.model.Planet;

@Service
public class PlanetDatabaseAppService {
	
	@Autowired
	private PlanetDataRepository planetDataRepository;
	
	public List<Planet> getAllPlanets(){
		List<Planet> planets =new ArrayList<Planet>();		
		planetDataRepository.findAll().forEach(planets::add);
		return planets;
	}
	
	public void addPlanets(List<Planet> planets) {		
		planetDataRepository.saveAll(planets);
	}
	
}

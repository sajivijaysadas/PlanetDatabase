package com.lexisnexis.PlanetDatabase.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lexisnexis.PlanetDatabase.model.Planet;
import com.lexisnexis.PlanetDatabase.service.PlanetDatabaseAppService;

@RestController
public class PlanetDatabaseAppController {
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(PlanetDatabaseAppController.class);
	
	@Autowired
	private PlanetDatabaseAppService planetDatabaseAppService;

    @RequestMapping(value = "/planets", method = RequestMethod.GET)
    public List<Planet> getAllPlanets(){
    	logger.info("Execute Get All Planets Controller");
		return planetDatabaseAppService.getAllPlanets();
	}
    
    @RequestMapping(value = "/addplanets", method = RequestMethod.POST)
    public void addAllPlanets(@RequestBody List<Planet> planets){
		planetDatabaseAppService.addPlanets(planets);
	}
}

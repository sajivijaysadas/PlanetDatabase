package com.lexisnexis.PlanetDatabase.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lexisnexis.PlanetDatabase.SpringConfiguration;
import com.lexisnexis.PlanetDatabase.Repository.PlanetDataRepository;
import com.lexisnexis.PlanetDatabase.model.Planet;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class TestPlanetDatabaseAppService {
	@Autowired
	PlanetDatabaseAppService planetDatabaseAppService;

	@Autowired
	PlanetDataRepository planetDataRepository;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() {
		reset(mock(PlanetDataRepository.class));
	}

	@Test
	public void getAllPlanetsTest() {
		List<Planet> list = new ArrayList<Planet>();
		Planet planetOne = new Planet();
		planetOne.setPlanetName("Mercury");
		planetOne.setPlanetId(new Long(1));
		planetOne.setImage("mercury.jpg");
		planetOne.setDistance("200");

		Planet planetTwo = new Planet();
		planetTwo.setPlanetName("Venus");
		planetTwo.setPlanetId(new Long(2));
		planetTwo.setImage("/Venus");
		planetTwo.setDistance("300");

		Planet planetThree = new Planet();
		planetThree.setPlanetName("Earth");
		planetThree.setPlanetId(new Long(3));
		planetThree.setImage("/earth");
		planetThree.setDistance("400");
		list.add(planetOne);
		list.add(planetTwo);
		list.add(planetThree);

		when(planetDataRepository.findAll()).thenReturn(list);
		List<Planet> planetList = planetDatabaseAppService.getAllPlanets();
		assertEquals(3, planetList.size());
		verify(planetDataRepository, times(2)).findAll();

	}

	@Test
	public void getAllPlanetsTest_NoResults() {
		try {
			List<Planet> list = null;
			when(mock(PlanetDataRepository.class).findAll()).thenReturn(list);
			List<Planet> planetList = planetDatabaseAppService.getAllPlanets();
			assertEquals(0, planetList.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

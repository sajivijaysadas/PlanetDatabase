package com.lexisnexis.PlanetDatabase.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
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
		List<Planet> planets = Arrays.asList(new Planet(1L, "Mercury", "mercury.jpg", "200,00,000"),
				new Planet(2L, "Venus", "Venus.jpg", "300,00,000"), new Planet(3L, "Earth", "earth.jpg", "400,000,00"));
		when(planetDataRepository.findAll()).thenReturn(planets);
		assertEquals(3, planetDatabaseAppService.getAllPlanets().size());
		verify(planetDataRepository, times(2)).findAll();

	}

	@Test
	public void getAllPlanetsTest_NoResults() {
		try {
			List<Planet> list = null;
			when(mock(PlanetDataRepository.class).findAll()).thenReturn(list);
			assertEquals(0, planetDatabaseAppService.getAllPlanets().size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

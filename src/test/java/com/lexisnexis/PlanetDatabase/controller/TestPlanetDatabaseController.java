package com.lexisnexis.PlanetDatabase.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.lexisnexis.PlanetDatabase.model.Planet;
import com.lexisnexis.PlanetDatabase.service.PlanetDatabaseAppService;

@RunWith(SpringRunner.class)
@WebMvcTest(PlanetDatabaseAppController.class) 
public class TestPlanetDatabaseController {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private PlanetDatabaseAppService planetDatabaseAppService;
	
	@Test
	public void getAllPlanetsTest() throws Exception {
		List<Planet> planets = Arrays.asList(new Planet(1L, "Mercury", "mercury.jpg", "200,00,000"),
				new Planet(2L, "Venus", "Venus.jpg", "300,00,000"), new Planet(3L, "Earth", "earth.jpg", "400,000,00"));
		when(planetDatabaseAppService.getAllPlanets()).thenReturn(planets);
		mvc.perform(get("/planets").header("Authorization", "Basic cGxhbmV0dXNlcjpwbGFuZXR1c2VyMTIz")
				.header("Authenticate", "Basic realm=MY_PLANET_REALM").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
}

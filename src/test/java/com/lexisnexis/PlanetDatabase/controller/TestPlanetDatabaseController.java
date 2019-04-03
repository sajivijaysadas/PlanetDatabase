package com.lexisnexis.PlanetDatabase.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.lexisnexis.PlanetDatabase.model.Planet;
import com.lexisnexis.PlanetDatabase.service.PlanetDatabaseAppService;

//@RunWith(SpringRunner.class)
//@WebMvcTest(PlanetDatabaseAppController.class) 
public class TestPlanetDatabaseController {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private PlanetDatabaseAppService planetDatabaseAppService;
	
	//@Test
	public void getAllPlanetsTest() throws Exception {
		List<Planet> planets = new ArrayList<>();
		Planet planet = new Planet();
		planet.setPlanetId(new Long(1));
		planet.setPlanetName("Mars");	
		planet.setDistance("34523452345");

		Planet planet1 = new Planet();
		planet.setPlanetId(new Long(2));
		planet1.setPlanetName("Venus");
		planet1.setDistance("323get4233452345");
		planets.add(planet);
		planets.add(planet1);
		when(planetDatabaseAppService.getAllPlanets()).thenReturn(planets);
		 mvc.perform(get("/planets").header("Authorization","cGxhbmV0dXNlcjpwbGFuZXR1c2VyMTIz")
				 .header("Authenticate", "Basic realm=MY_PLANET_REALM")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk());
	}
}

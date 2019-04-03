package com.lexisnexis.PlanetDatabase;

import static org.mockito.Mockito.mock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lexisnexis.PlanetDatabase.Repository.PlanetDataRepository;
import com.lexisnexis.PlanetDatabase.service.PlanetDatabaseAppService;

@Configuration
public class SpringConfiguration {
	@Bean
	public PlanetDatabaseAppService getPlanetService() {
		return new PlanetDatabaseAppService();
	}

	@Bean
	public PlanetDataRepository planetDataRepository() {
		return mock(PlanetDataRepository.class);
	}
}

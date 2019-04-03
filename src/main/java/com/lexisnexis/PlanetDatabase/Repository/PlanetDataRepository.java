package com.lexisnexis.PlanetDatabase.Repository;

import org.springframework.data.repository.CrudRepository;

import com.lexisnexis.PlanetDatabase.model.Planet;

public interface PlanetDataRepository extends CrudRepository<Planet,Long>{}

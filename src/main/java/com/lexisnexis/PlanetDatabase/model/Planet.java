package com.lexisnexis.PlanetDatabase.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PLANET_DETAILS")
public class Planet {

	@Id
	@Column(name = "PLANET_ID")
	private Long planetId;
	@Column(name="PLANET_NAME")
	private String planetName;
	@Column(name = "IMAGE")
	private String image;
	@Column(name = "DISTANCE")
	private String distance;
	
	public String getPlanetName() {
		return planetName;
	}
	public void setPlanetName(String planetName) {
		this.planetName = planetName;
	}
	
	public Long getPlanetId() {
		return planetId;
	}
	public void setPlanetId(Long planetId) {
		this.planetId = planetId;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
}

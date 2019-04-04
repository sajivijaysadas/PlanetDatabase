package com.lexisnexis.PlanetDatabase.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PLANET_DETAILS")
public class Planet {

	@Id
	@Column(name = "PLANET_ID", length = 20)
	private Long planetId;
	@Column(name="PLANET_NAME", length = 30)
	private String planetName;
	@Column(name = "IMAGE", length = 30)
	private String image;
	@Column(name = "DISTANCE", length = 30)
	private String distance;
	
	public Planet() {
		
	}
	public Planet(Long planetId, String planetName, String image, String distance) {
		this.planetId = planetId;
		this.planetName = planetName;
		this.image = image;
		this.distance = distance;
	}
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

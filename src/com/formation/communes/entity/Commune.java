package com.formation.communes.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="communes")
@Access(AccessType.FIELD)

@NamedQuery(name="Commune.findByCodePostal",
			query = "SELECT c FROM Commune c WHERE c.codePostal LIKE :cp")
@NamedQuery(name="Commune.regions",
			query = "SELECT DISTINCT c.region FROM Commune c")
public class Commune {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nom;
	private String departement;
	private String region;
	@Column(name = "code_postal")
	private String codePostal;
	private double latitude;
	private double longitude;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDepartement() {
		return departement;
	}
	public void setDepartement(String departement) {
		this.departement = departement;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	

}

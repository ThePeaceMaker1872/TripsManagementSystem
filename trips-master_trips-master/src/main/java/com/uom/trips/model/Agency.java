package com.uom.trips.model;

import java.util.*;
import javax.persistence.*;


@Entity
@Table(name = "agencies")
public class Agency {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int agencyid;
	private String afm;
	private String name;
	private String owner;
	private String password;
	
	@OneToMany(mappedBy = "agency", cascade= CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Trip> trips = new ArrayList<Trip>();
	
	
	public Agency() {}
	
	public Agency(int agencyid, String afm, String name, String owner, String password) {
		
		this.agencyid = agencyid;
		this.afm = afm;
		this.name = name;
		this.owner = owner;
		this.password = password;
		
	}
	
	public Agency(String afm, String name, String owner, String password) {
		this.afm = afm;
		this.name = name;
		this.owner = owner;
		this.password = password;
	}

	public int getAgencyid() {
		return agencyid;
	}

	public void setAgencyid(int agencyid) {
		this.agencyid = agencyid;
	}

	public String getAfm() {
		return afm;
	}

	public void setAfm(String afm) {
		this.afm = afm;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	//new
	public void addTrip(Trip trip) {
		trips.add(trip);
	}
	
	
}

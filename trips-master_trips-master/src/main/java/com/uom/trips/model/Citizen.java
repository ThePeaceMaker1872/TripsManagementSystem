package com.uom.trips.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;



@Entity
@Table(name = "citizens")
public class Citizen {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int citizenId;
	private String afm;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name="reservations",
		joinColumns = @JoinColumn(name="citizenId"),
	   inverseJoinColumns = @JoinColumn(name="travelId"))
	private Set<Trip> trips = new HashSet<Trip>();
	
	

	//new
	public void addTripToCitizen(Trip t) throws Exception {
		trips.add(t);	
	}
	
	public Citizen() {}
	
	
	public Citizen(String afm, String firstName, String lastName, String email, String password) {
		this.afm = afm;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	
	public Citizen(String afm, String firstName, String lastName, String email, String password, Set<Trip> trips) {
		this.afm = afm;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.trips = trips;
	}

	public Citizen(int citizenId, String afm, String firstName, String lastName, String email, String password,
			Set<Trip> trips) {
		this.citizenId = citizenId;
		this.afm = afm;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.trips = trips;
	}
	
	public Citizen(int citizenId, String afm, String firstName, String lastName, String email, String password) {
		this.citizenId = citizenId;
		this.afm = afm;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public int getCitizenId() {
		return citizenId;
	}

	public void setCitizenId(int citizenId) {
		this.citizenId = citizenId;
	}

	public String getAfm() {
		return afm;
	}

	public void setAfm(String afm) {
		this.afm = afm;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setTrips(Set<Trip> trips) {
		this.trips = trips;
	}
	
	public Set<Trip> getTrips() {return trips;}

	

}

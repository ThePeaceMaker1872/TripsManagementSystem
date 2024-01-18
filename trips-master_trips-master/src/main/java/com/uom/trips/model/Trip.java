package com.uom.trips.model;

import java.sql.*;
import javax.persistence.*;

import java.util.Date; 
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "trips")
public class Trip {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int travelId;
	private String departureLocation;
	private String arrivalLocation;
	private Date departureDate;
	private Date arrivalDate;
	private int maxLimit;
	
	@ManyToOne
	@JoinColumn(name = "agencyid")
	private Agency agency;
	
	
	@ManyToMany(mappedBy="trips")
	private Set<Citizen> citizens = new HashSet<Citizen>();

		
	public Trip() {}
	
	public Trip(String departureLocation, String arrivalLocation, Date departureDate, Date arrivalDate, int maxLimit,
			Agency agency) {
		this.departureLocation = departureLocation;
		this.arrivalLocation = arrivalLocation;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.maxLimit = maxLimit;
		this.agency = agency;
	}

	public Trip(String departureLocation, String arrivalLocation, Date departureDate, Date arrivalDate, int maxLimit,
			Agency agency, Set<Citizen> citizens) {
		this.departureLocation = departureLocation;
		this.arrivalLocation = arrivalLocation;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.maxLimit = maxLimit;
		this.agency = agency;
		this.citizens = citizens;
	}

	public Trip(int travelId, String departureLocation, String arrivalLocation, Date departureDate, Date arrivalDate,
			int maxLimit, Agency agency, Set<Citizen> citizens) {
		this.travelId = travelId;
		this.departureLocation = departureLocation;
		this.arrivalLocation = arrivalLocation;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.maxLimit = maxLimit;
		this.agency = agency;
		this.citizens = citizens;
	}
	
	public int getTravelId() {
		return travelId;
	}

	public void setTravelId(int travelId) {
		this.travelId = travelId;
	}

	public String getDepartureLocation() {
		return departureLocation;
	}

	public void setDepartureLocation(String departureLocation) {
		this.departureLocation = departureLocation;
	}

	public String getArrivalLocation() {
		return arrivalLocation;
	}

	public void setArrivalLocation(String arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public int getMaxLimit() {
		return maxLimit;
	}

	public void setMaxLimit(int maxLimit) {
		this.maxLimit = maxLimit;
	}

	public Set<Citizen> getCitizens() {
		return citizens;
	}

	public void setCitizens(Set<Citizen> citizens) {
		this.citizens = citizens;
	}

	public Agency getAgency() {
		return agency;
	}

	//new
	public void setAgency(Agency agency) {
		this.agency = agency;
		agency.addTrip(this);
	}


}

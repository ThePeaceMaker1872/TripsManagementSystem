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
	
	@OneToMany(mappedBy = "trip", cascade = CascadeType.ALL)
	private List<Reservation> reservations;
	
	
	public Trip() {}
	
	public Trip(int travelId, String departureLocation, String arrivalLocation, Date departureDate, Date arrivalDate,
			int maxLimit, Agency agency) {
		super();
		this.travelId = travelId;
		this.departureLocation = departureLocation;
		this.arrivalLocation = arrivalLocation;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.maxLimit = maxLimit;
		this.agency = agency;
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

	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}


}

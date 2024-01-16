package com.uom.trips.model;

import javax.persistence.*;

@Entity
@Table(name = "reservations")
public class Reservation {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reservationId;
	
	@ManyToOne
	@JoinColumn(name = "citizenId")
	private Citizen citizen;
	
	@ManyToOne
	@JoinColumn(name = "travelId")
	private Trip trip;
	
	
	public Reservation() {}
	
	public Reservation(int reservationId, Citizen citizen, Trip trip) {
		super();
		this.reservationId = reservationId;
		this.citizen = citizen;
		this.trip = trip;
	}

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public Citizen getCitizen() {
		return citizen;
	}

	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

}

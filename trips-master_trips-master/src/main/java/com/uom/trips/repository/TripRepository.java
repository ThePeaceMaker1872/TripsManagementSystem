package com.uom.trips.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uom.trips.model.Trip;

public interface TripRepository extends JpaRepository<Trip, Integer>{
	
	//Optional<Trip> findByArrivalLocation(String arrivalLocation);
	
	public List<Trip> findByArrivalLocation(String arrivalLocation);
	
	public List<Trip> findByDepartureLocation(String departureLocation);
		
	
	
	
}

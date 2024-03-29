package com.uom.trips.service;

import com.uom.trips.model.Agency;
import com.uom.trips.model.Citizen;

import java.util.*;


import com.uom.trips.model.Trip;
import com.uom.trips.repository.AgencyRepository;
import com.uom.trips.repository.CitizenRepository;
import com.uom.trips.repository.TripRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TripService {
	
	@Autowired
	private TripRepository tripRepository;
	
	@Autowired
	private AgencyRepository agencyRepository;
	
	@Autowired
	private CitizenRepository citizenRepository;
	
	public List<Trip> getAllTrips() throws Exception{
		return tripRepository.findAll();
		
	}
	
	
	public void addTrip(Trip trip) throws Exception {
        Optional<Agency> optionalAgency = agencyRepository.findById(trip.getTravelId());

        if (!optionalAgency.isPresent()) {
            
            tripRepository.save(trip);
        }  
   
	}
	
	
	
	public List<Trip> findTripsByArrivalLocation(String arrivalLocation) throws Exception{
		return tripRepository.findByArrivalLocation(arrivalLocation);
	}
	
	public List<Trip> findTripsByDepartureLocation(String departureLocation) throws Exception{
		return tripRepository.findByDepartureLocation(departureLocation);
	}
}

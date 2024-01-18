package com.uom.trips.service;

import com.uom.trips.model.Agency;

import java.util.*;


import com.uom.trips.model.Trip;
import com.uom.trips.repository.AgencyRepository;
import com.uom.trips.repository.TripRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TripService {
	
	@Autowired
	private TripRepository tripRepository;
	
	@Autowired
	private AgencyRepository agencyRepository;
	
	public List<Trip> getAllTrips() throws Exception{
		return tripRepository.findAll();
		
	}
	
	public void addTrip2(Trip trip) throws Exception {
		tripRepository.save(trip);
	}
	
	
	
	public void addTrip(Trip trip) throws Exception {
        Optional<Agency> optionalAgency = agencyRepository.findById(trip.getTravelId());

        if (!optionalAgency.isPresent()) {
            
            tripRepository.save(trip);
        }    
   
	}
	
	
	public Trip getTripById(int travelId) throws Exception{
		return tripRepository.findById(travelId);
		
	}
	
	
	public List<Trip> findTripsByArrivalLocation(String arrivalLocation) throws Exception{
		return tripRepository.findByArrivalLocation(arrivalLocation);
	}
	
	public List<Trip> findTripsByDepartureLocation(String departureLocation) throws Exception{
		return tripRepository.findByDepartureLocation(departureLocation);
	}
}

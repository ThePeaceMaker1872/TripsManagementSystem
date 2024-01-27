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
	
	/*public void registerCitizenToTrip(Trip trip) {
		
		Optional<Trip> tripByIOptional = tripRepository.findById(trip.getTravelId());
		//Optional<Citizen> CitizenbyIdOptional = citizenRepository.findById(citizen.getCitizenId());
		
	
	
		int maxLimit = trip.getMaxLimit();
		if (maxLimit > 0) {
			trip.setMaxLimit(maxLimit - 1);
			//citizen.addTripToCitizen(trip);
			trip.registerCitizenToTrip(citizen);
			// Save as a good practice, since cascadeType is not .ALL
			tripRepository.save(trip);
			//citizenRepository.save(citizen);
			} 
			else {
				throw new Exception();
				//System.out.println("No available seats for this trip.");
			}
	}*/
	
	//new
	/*public Trip trip (int tripId) {
		Trip trip = tripRepository.findById(tripId);
		return trip;
			}
	
	
	public Trip getTripById(int travelId) throws Exception{
		return tripRepository.findById(travelId);
		
	}*/
	
	
	public List<Trip> findTripsByArrivalLocation(String arrivalLocation) throws Exception{
		return tripRepository.findByArrivalLocation(arrivalLocation);
	}
	
	public List<Trip> findTripsByDepartureLocation(String departureLocation) throws Exception{
		return tripRepository.findByDepartureLocation(departureLocation);
	}
}

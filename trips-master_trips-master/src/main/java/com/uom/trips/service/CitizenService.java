package com.uom.trips.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uom.trips.model.Citizen;
import com.uom.trips.model.Trip;
import com.uom.trips.repository.CitizenRepository;
import com.uom.trips.repository.TripRepository;

@Service
public class CitizenService {
	
	@Autowired
	private CitizenRepository citizenRepository;
	
	//new
	@Autowired
	private TripRepository tripRepository;
	
	
	public void registerCitizen(Citizen citizen) throws Exception{
		citizenRepository.save(citizen);
	}
	
	
	//new
	public Citizen citizen (String citizenAfm) {
		Citizen citizen = citizenRepository.findByAfm(citizenAfm);
		return citizen;
		}
	
	
	
	/*public void registerToTrip(int citizenId, int travelId) throws Exception {
		Optional<Citizen> citizen = citizenRepository.findById(citizenId);
		Optional<Trip> trip = tripRepository.findById(travelId);
	
	
		int maxLimit = trip.getMaxLimit();
		if (maxLimit > 0) {
			trip.setMaxLimit(maxLimit - 1);
			citizen.addTripToCitizen(trip);
			trip.addCitizenToTrip(citizen);
			// Save as a good practice, since cascadeType is not .ALL
			tripRepository.save(trip);
			citizenRepository.save(citizen);
			} 
			else {
				throw new Exception();
				//System.out.println("No available seats for this trip.");
			}
		
	}*/
	
	
	public void registerToTrip(Trip trip, Citizen citizen) throws Exception {
		
		//Optional<Citizen> CitizenbyIdOptional = citizenRepository.findById(citizen.getCitizenId());
		Optional<Trip> tripByIOptional = tripRepository.findById(trip.getTravelId());
	
	
		int maxLimit = trip.getMaxLimit();
		if (maxLimit > 0) {
			trip.setMaxLimit(maxLimit - 1);
			citizen.addTripToCitizen(trip);
			trip.registerCitizenToTrip(citizen);
			// Save as a good practice, since cascadeType is not .ALL
			tripRepository.save(trip);
			//citizenRepository.save(citizen);
			} 
			else {
				throw new Exception();
				//System.out.println("No available seats for this trip.");
			}
		
	}
	
	public Citizen signIn(String email, String password) throws Exception {
   	   
       System.out.println("Received email: " + email);
       System.out.println("Received password: " + password);
   	
   	
   	   
       Citizen citizen = citizenRepository.findByEmail(email);
       
       
       System.out.println("Retrieved Citizen: " + citizen);

       // Check if the citizen exists and the password matches
       if (citizen != null && citizen.getPassword().equals(password)) {
           return citizen;
       } else {
           // If no matching citizen is found or the password is incorrect, return null
           return null;
       }
   }


	public List<Citizen> getAllCitizens() throws Exception{
		return citizenRepository.findAll();
		
	}
	
	
	
	
	

}


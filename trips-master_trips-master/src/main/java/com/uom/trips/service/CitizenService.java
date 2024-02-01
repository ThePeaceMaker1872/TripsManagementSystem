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
	
	@Autowired
	private TripRepository tripRepository;
	
	
	
	public void register(Citizen citizen) throws Exception{
		
		Optional<Citizen> findByAfm = citizenRepository.findByAfm(citizen.getAfm());
		Optional<Citizen> findByEmail = citizenRepository.findByEmail(citizen.getEmail());
				
		if(!findByAfm.isPresent()) {
			
			if (!findByEmail.isPresent()) {
				citizenRepository.save(citizen);
			}
			else {
				throw new Exception("Email already exists!");
			}
		}
		else {
			throw new Exception("Afm already exists!");
		}
    }
	
	
	public Optional<Citizen> signIn(String email, String password) throws Exception {
		 
		Optional<Citizen> findByEmail = citizenRepository.findByEmail(email);
	        
	    if (findByEmail.isPresent()) {
	        Citizen citizen = findByEmail.get();
	        
	        if (citizen.getPassword().equals(password)) {
	            return Optional.of(citizen);
	        } else {
	            throw new Exception("Wrong password");
	        }
	    } else {
	        throw new Exception("Wrong email");
	    }
	}


	
	public void registerToTrip(Trip trip, Citizen citizen) throws Exception {
		
	
		int maxLimit = trip.getMaxLimit();
		if (maxLimit > 0) {
			trip.setMaxLimit(maxLimit - 1);
			citizen.addTripToCitizen(trip);
			trip.registerCitizenToTrip(citizen);
			
			tripRepository.save(trip);
			
			} 
			else {
				throw new Exception();
				
			}
		
	}
	

	public List<Citizen> getAllCitizens() throws Exception{
		return citizenRepository.findAll();
		
	}

}




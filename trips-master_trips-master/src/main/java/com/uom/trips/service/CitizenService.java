package com.uom.trips.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uom.trips.model.Citizen;
import com.uom.trips.model.Trip;
import com.uom.trips.repository.CitizenRepository;

@Service
public class CitizenService {
	
	@Autowired
	private CitizenRepository citizenRepository;
	
	
	public void registerCitizen(Citizen citizen) throws Exception{
		citizenRepository.save(citizen);
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
	
	public void registerToTrip(Trip t) {
		int maxLimit = t.getMaxLimit();
	    if (maxLimit > 0) {
	        t.setMaxLimit(maxLimit - 1);
	        //trips.add(t);
	    } else {
	        System.out.println("No available seats for this trip.");
	    }
	}
	
	

}


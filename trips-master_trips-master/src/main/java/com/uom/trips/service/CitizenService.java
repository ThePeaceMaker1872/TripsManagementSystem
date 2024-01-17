package com.uom.trips.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uom.trips.model.Citizen;
import com.uom.trips.repository.CitizenRepository;

@Service
public class CitizenService {
	
	@Autowired
	private CitizenRepository citizenRepository;
	
	
	public void registerCitizen(Citizen citizen) throws Exception{
		citizenRepository.save(citizen);
	}
	
	
	public Citizen signIn(String email, String password) throws Exception {
   	   // Log the received credentials for debugging
       System.out.println("Received email: " + email);
       System.out.println("Received password: " + password);
   	
   	
   	   // Find the citizen with the given email
       Citizen citizen = citizenRepository.findByEmail(email);
       
       // Log the retrieved Citizen object
       System.out.println("Retrieved Citizen: " + citizen);

       // Check if the citizen exists and the password matches
       if (citizen != null && citizen.getPassword().equals(password)) {
           return citizen;
       } else {
           // If no matching citizen is found or the password is incorrect, return null
           return null;
       }
   }

}

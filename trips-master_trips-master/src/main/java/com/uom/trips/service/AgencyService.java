package com.uom.trips.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uom.trips.model.Agency;
import com.uom.trips.model.Trip;
import com.uom.trips.repository.AgencyRepository;
import com.uom.trips.repository.TripRepository;

@Service
public class AgencyService {
	
	@Autowired
	private AgencyRepository agencyRepository;
	
	@Autowired
	private TripRepository tripRepository;
	
	public void	registerAgency(Agency agency) throws Exception{
		agencyRepository.save(agency);
	}
	
	
	public Agency signIn(String afm, String password) throws Exception {
	   	 
	       System.out.println("Received afm: " + afm);
	       System.out.println("Received password: " + password);
	   	
	   	
	   	
	       Agency agency = agencyRepository.findByAfm(afm);
	       
	      
	       System.out.println("Retrieved Agency: " + agency);

	       // Check if the citizen exists and the password matches
	       if (agency != null && agency.getPassword().equals(password)) {
	           return agency;
	       } else {
	           // If no matching citizen is found or the password is incorrect, return null
	           return null;
	       }
	}
	
	public void addTrip(Trip trip) throws Exception {
        Optional<Agency> optionalAgency = agencyRepository.findById(trip.getTravelId());

        if (!optionalAgency.isPresent()) {
            
            tripRepository.save(trip);
        }  
   
	}
	
	//new
	public List<Agency> getAllAgencies() throws Exception{
		return agencyRepository.findAll();
		
	}
}

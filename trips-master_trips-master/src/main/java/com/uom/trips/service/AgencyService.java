package com.uom.trips.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uom.trips.model.Agency;
import com.uom.trips.model.Citizen;
import com.uom.trips.model.Trip;
import com.uom.trips.repository.AgencyRepository;
import com.uom.trips.repository.TripRepository;

@Service
public class AgencyService {
	
	@Autowired
	private AgencyRepository agencyRepository;
	
	@Autowired
	private TripRepository tripRepository;
	
	public void register(Agency agency) throws Exception{
		
		Optional<Agency> findByAfm = agencyRepository.findByAfm(agency.getAfm());
					
		if(!findByAfm.isPresent()) {
			
			agencyRepository.save(agency);
		}
		else {
			throw new Exception("Afm already exists!");
		}
    }
	

	public Optional<Agency> signIn(String afm, String password) throws Exception {
		 
		Optional<Agency> findByAfm = agencyRepository.findByAfm(afm);
	        
	    if (findByAfm.isPresent()) {
	        Agency agency = findByAfm.get();
	        
	        if (agency.getPassword().equals(password)) {
	            return Optional.of(agency);
	        } else {
	            throw new Exception("Wrong password");
	        }
	    } else {
	        throw new Exception("Wrong Afm");
	    }
	}
	
	public void addTrip(Trip trip) throws Exception {
        Optional<Agency> optionalAgency = agencyRepository.findById(trip.getTravelId());

        if (!optionalAgency.isPresent()) {
            
            tripRepository.save(trip);
        }  
   
	}
	
	public List<Agency> getAllAgencies() throws Exception{
		return agencyRepository.findAll();
		
	}
}

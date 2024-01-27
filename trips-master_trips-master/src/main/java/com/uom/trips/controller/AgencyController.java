package com.uom.trips.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.uom.trips.model.Agency;
import com.uom.trips.model.Trip;
import com.uom.trips.service.AgencyService;
import com.uom.trips.service.TripService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class AgencyController {
	
	@Autowired
	private AgencyService agencyService;
	
	@Autowired
	private TripService tripService;
	
	@PostMapping(path = "/agency/register")
	public void registerAgency(@RequestBody Agency agency) throws Exception{
		agencyService.registerAgency(agency);
	}
	
	//new
	@GetMapping(path = "/agencies")
	public List<Agency> getAllAgencies() throws Exception{
		return agencyService.getAllAgencies();
	}
	
	@PostMapping(path = "/agency/signin")
	public ResponseEntity<?> signIn(@RequestParam String afm, @RequestParam String password) {
	    try {
	        Agency signedInAgency = agencyService.signIn(afm, password);

	        if (signedInAgency != null) {
	            
	        	Map<String, Object> response = new HashMap<>();
	        	response.put("agencyid", signedInAgency.getAgencyid());
		        response.put("name", signedInAgency.getName());
		        response.put("message", "Sign-in successful");
		        return ResponseEntity.ok(response);
	            
	        } else {
	            // Invalid credentials
	            return ResponseEntity.status(401).body("Invalid email or password");
	        }
	    } catch (Exception e) {
	        
	        return ResponseEntity.status(500).body("Internal server error");
	    }
	}
	
	@PostMapping(path = "/addTrip")
	public void addTrip(@RequestBody Trip trip) throws Exception{
		tripService.addTrip(trip);
	}
	
	

}



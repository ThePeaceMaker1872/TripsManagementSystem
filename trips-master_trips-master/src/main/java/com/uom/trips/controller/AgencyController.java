package com.uom.trips.controller;

import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import com.uom.trips.model.Agency;
import com.uom.trips.model.Citizen;
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
	public ResponseEntity<String> register(@Valid @RequestBody Agency agency, BindingResult result){
		
		if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(getValidationErrors(result));
        }
		
		try {
			agencyService.register(agency);
			return ResponseEntity.ok("Register successfully!"); 
		} catch (Exception e) {
			return ResponseEntity.status(400).body(e.getMessage());
		}
		
		
	}
	
	//new
	@GetMapping(path = "/agencies")
	public List<Agency> getAllAgencies() throws Exception{
		return agencyService.getAllAgencies();
	}
	
	@PostMapping(path = "/agency/signin")
	public ResponseEntity<?> signIn(@RequestParam String afm, @RequestParam String password) {
	    try {
	        Optional<Agency> signedInAgency = agencyService.signIn(afm, password);

	        if (signedInAgency.isPresent()) {
	            Agency agency = signedInAgency.get();

	            Map<String, Object> response = new HashMap<>();
	            response.put("message", "Sign-in successful");
	            response.put("AgencyId", agency.getAgencyid());
	            response.put("Name", agency.getName());
	            return ResponseEntity.ok(response);
	        } else {
	            // Handle the case when the optional is empty (user not found)
	            return ResponseEntity.status(404).body("User not found");
	        }
	    } catch (Exception e) {
	        return ResponseEntity.status(400).body(e.getMessage());
	    }
	}

	
	@PostMapping(path = "/addTrip")
	public void addTrip(@RequestBody Trip trip) throws Exception{
		tripService.addTrip(trip);
	}
	
	
	private String getValidationErrors(BindingResult result) {
        StringBuilder errors = new StringBuilder();
        result.getFieldErrors().forEach(error -> errors.append(error.getDefaultMessage()).append(" "));
        return errors.toString().trim();
    }
	
	

}



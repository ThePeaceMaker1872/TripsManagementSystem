package com.uom.trips.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.uom.trips.model.Agency;
import com.uom.trips.model.Citizen;
import com.uom.trips.model.Trip;
import com.uom.trips.service.CitizenService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class CitizenController {
	
	@Autowired
	private CitizenService citizenService;
	
	@PostMapping(path = "/register")
	public void registerCitizen(@RequestBody Citizen citizen) throws Exception{
		citizenService.registerCitizen(citizen);
	}
	
	//new
	@PostMapping(path = "/signin")

	public ResponseEntity<?> signIn(@RequestParam String email, @RequestParam String password) {
		
	   try {
	       Citizen signedInCitizen = citizenService.signIn(email, password);

	       if (signedInCitizen != null) {
         
	           Map<String, Object> response = new HashMap<>();
	           response.put("citizenId", signedInCitizen.getCitizenId());
	           response.put("firstName", signedInCitizen.getFirstName());
	           response.put("message", "Sign-in successful");
	           return ResponseEntity.ok(response);

	       } else {
	          return ResponseEntity.status(401).body("Invalid email or password");
	       }
	   } catch (Exception e) {
	       return ResponseEntity.status(500).body("Internal server error");
	   }
	}
	
		
	//new
	@PostMapping(path = "/registerToTrip")
	public ResponseEntity<String> registerToTrip(@RequestParam("citizenId") int citizenId, 
            @RequestParam("travelId") int travelId) {
		try {
			citizenService.registerToTrip(citizenId, travelId);
			return ResponseEntity.ok("Successfully registered to the trip.");
		} catch (Exception e) {
			// Handle exceptions if needed
	        return ResponseEntity.status(500).body("No available seats!");
		}
	}

}

package com.uom.trips.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.uom.trips.model.Agency;
import com.uom.trips.model.Citizen;
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
	
	@PostMapping(path = "/signin")
	public ResponseEntity<?> signIn(@RequestParam String email, @RequestParam String password) {
	    try {
	        Citizen signedInCitizen = citizenService.signIn(email, password);

	        if (signedInCitizen != null) {
	            // Return some information about the signed-in citizen if needed
	            // You can customize this response based on your requirements
	            return ResponseEntity.ok("Sign-in successful");
	        } else {
	            // Invalid credentials
	            return ResponseEntity.status(401).body("Invalid email or password");
	        }
	    } catch (Exception e) {
	        // Handle exceptions if needed
	        return ResponseEntity.status(500).body("Internal server error");
	    }
	}

}

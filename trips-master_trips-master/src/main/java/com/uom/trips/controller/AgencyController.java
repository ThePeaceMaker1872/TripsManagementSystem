package com.uom.trips.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.uom.trips.model.Agency;
import com.uom.trips.service.AgencyService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class AgencyController {
	
	@Autowired
	private AgencyService agencyService;
	
	@PostMapping(path = "/agency/register")
	public void registerAgency(@RequestBody Agency agency) throws Exception{
		agencyService.registerAgency(agency);
	}
	
	
	@PostMapping(path = "/agency/signin")
	public ResponseEntity<?> signIn(@RequestParam String afm, @RequestParam String password) {
	    try {
	        Agency signedInAgency = agencyService.signIn(afm, password);

	        if (signedInAgency != null) {
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

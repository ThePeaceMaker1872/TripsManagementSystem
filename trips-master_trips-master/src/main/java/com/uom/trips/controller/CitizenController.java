package com.uom.trips.controller;




import java.util.*;

import javax.validation.Valid;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
	public ResponseEntity<String> register(@Valid @RequestBody Citizen citizen, BindingResult result){
		
		if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(getValidationErrors(result));
        }
		
		try {
			citizenService.register(citizen);
			return ResponseEntity.ok("Register successfully!"); 
		} catch (Exception e) {
			return ResponseEntity.status(400).body(e.getMessage());
		}
		
		
	}
	
			
		 
	@PostMapping(path = "/signin")
	public ResponseEntity<?> signIn(@RequestParam String email, @RequestParam String password) {
	    try {
	        Optional<Citizen> signedInCitizen = citizenService.signIn(email, password);

	        if (signedInCitizen.isPresent()) {
	            Citizen citizen = signedInCitizen.get();

	            Map<String, Object> response = new HashMap<>();
	            response.put("message", "Sign-in successful");
	            response.put("citizenId", citizen.getCitizenId());
	            response.put("firstName", citizen.getFirstName());
	            return ResponseEntity.ok(response);
	        } else {
	            
	            return ResponseEntity.status(404).body("User not found");
	        }
	    } catch (Exception e) {
	        return ResponseEntity.status(400).body(e.getMessage());
	    }
	}


	
	@PostMapping(path = "/registerToTrip")
	public ResponseEntity<String> registerToTrip(@RequestParam Trip trip, @RequestParam Citizen citizen
          ) {
		try {
			citizenService.registerToTrip(trip,citizen);
			return ResponseEntity.ok("Successfully registered to the trip.");
		} catch (Exception e) {
			// Handle exceptions if needed
	        return ResponseEntity.status(500).body("No available seats!");
		}
	}
	
	
	
	@GetMapping(path = "/citizens")
	public List<Citizen> getAllCitizens() throws Exception {
		return citizenService.getAllCitizens();
	}
	
	
	private String getValidationErrors(BindingResult result) {
        StringBuilder errors = new StringBuilder();
        result.getFieldErrors().forEach(error -> errors.append(error.getDefaultMessage()).append(" "));
        return errors.toString().trim();
    }

}



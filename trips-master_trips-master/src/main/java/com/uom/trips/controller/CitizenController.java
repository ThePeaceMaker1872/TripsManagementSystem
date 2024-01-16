package com.uom.trips.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

}

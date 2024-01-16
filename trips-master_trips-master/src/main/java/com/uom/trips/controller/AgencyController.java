package com.uom.trips.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

}

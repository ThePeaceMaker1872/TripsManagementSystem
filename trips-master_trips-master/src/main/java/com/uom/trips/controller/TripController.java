package com.uom.trips.controller;


import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.uom.trips.exception.ResourseNotFoundException;
import com.uom.trips.model.Agency;
import com.uom.trips.model.Trip;
import com.uom.trips.repository.AgencyRepository;
import com.uom.trips.repository.TripRepository;
import com.uom.trips.service.AgencyService;
import com.uom.trips.service.TripService;

import java.util.*;



@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class TripController {
	
	@Autowired
	private TripService tripService;
	
	
	
	@GetMapping(path = "/trips")
	public List<Trip> getAllTrips() throws Exception{
		return tripService.getAllTrips();
	}
	
	

	/*@GetMapping(path = "/trips/{id}")
	public Trip getTripbyId(@PathVariable ("id") int travelId) throws Exception {
		return tripService.getTripById(travelId);
			
	}*/
	
	
	@GetMapping(path = "/trips/arrivallocation/{arrivallocation}")
	public List<Trip> getTripsByArrivalLocation(@PathVariable ("arrivallocation") String arrivalLocation) throws Exception{
		return tripService.findTripsByArrivalLocation(arrivalLocation);
		
	}
	
	@GetMapping(path = "/trips/departurelocation/{departurelocation}")
	public List<Trip> getTripsByDepartureLocation(@PathVariable ("departurelocation") String departureLocation) throws Exception{
		return tripService.findTripsByDepartureLocation(departureLocation);
	}
	
}

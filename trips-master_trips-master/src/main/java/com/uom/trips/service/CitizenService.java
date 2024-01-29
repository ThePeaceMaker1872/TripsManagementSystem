package com.uom.trips.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uom.trips.model.Citizen;
import com.uom.trips.model.Trip;
import com.uom.trips.repository.CitizenRepository;
import com.uom.trips.repository.TripRepository;

@Service
public class CitizenService {
	
	@Autowired
	private CitizenRepository citizenRepository;
	
	@Autowired
	private TripRepository tripRepository;
	
	
	
	public void register(Citizen citizen) throws Exception{
		
		Optional<Citizen> findByAfm = citizenRepository.findByAfm(citizen.getAfm());
		Optional<Citizen> findByEmail = citizenRepository.findByEmail(citizen.getEmail());
				
		if(!findByAfm.isPresent()) {
			
			if (!findByEmail.isPresent()) {
				citizenRepository.save(citizen);
			}
			else {
				throw new Exception("Email already exists!");
			}
		}
		else {
			throw new Exception("Afm already exists!");
		}
    }
	
	
	public Optional<Citizen> signIn(String email, String password) throws Exception {
		 
		Optional<Citizen> findByEmail = citizenRepository.findByEmail(email);
	        
	    if (findByEmail.isPresent()) {
	        Citizen citizen = findByEmail.get();
	        
	        if (citizen.getPassword().equals(password)) {
	            return Optional.of(citizen);
	        } else {
	            throw new Exception("Wrong password");
	        }
	    } else {
	        throw new Exception("Wrong email");
	    }
	}


	
	public void registerToTrip(Trip trip, Citizen citizen) throws Exception {
		
		//Optional<Citizen> CitizenbyIdOptional = citizenRepository.findById(citizen.getCitizenId());
		//Optional<Trip> tripByIOptional = tripRepository.findById(trip.getTravelId());
	
	
		int maxLimit = trip.getMaxLimit();
		if (maxLimit > 0) {
			trip.setMaxLimit(maxLimit - 1);
			citizen.addTripToCitizen(trip);
			trip.registerCitizenToTrip(citizen);
			// Save as a good practice, since cascadeType is not .ALL
			tripRepository.save(trip);
			//citizenRepository.save(citizen);
			} 
			else {
				throw new Exception();
				//System.out.println("No available seats for this trip.");
			}
		
	}
	

	public List<Citizen> getAllCitizens() throws Exception{
		return citizenRepository.findAll();
		
	}

}





/*public void registerCitizen(Citizen citizen) throws Exception{

	if (isEmailUnique(citizen.getEmail()) && isAfmUnique(citizen.getAfm())) {
	citizenRepository.save(citizen);
	} else {
		throw new Exception();
	}
}*/

/*private boolean isEmailUnique(String email) {
	// Check if there is already a citizen with the given email in the database
	Citizen existingCitizen = citizenRepository.findByEmail(email);
	return existingCitizen == null;
}

private boolean isAfmUnique(String afm) {
	// Check if there is already a citizen with the given AFM in the database
	Citizen existingCitizen = citizenRepository.findByAfm(afm);
	return existingCitizen == null;
}*/





//new??????????????
/*public Citizen citizen (String citizenAfm) {
		Citizen citizen = citizenRepository.findByAfm(citizenAfm);
		return citizen;
}*/






/*public void registerToTrip(int citizenId, int travelId) throws Exception {
	Optional<Citizen> citizen = citizenRepository.findById(citizenId);
	Optional<Trip> trip = tripRepository).findById(travelId);


	int maxLimit = trip.getMaxLimit();
	if (maxLimit > 0) {
		trip.setMaxLimit(maxLimit - 1);
		citizen.addTripToCitizen(trip);
		trip.addCitizenToTrip(citizen);
		// Save as a good practice, since cascadeType is not .ALL
		tripRepository.save(trip);
		citizenRepository.save(citizen);
		} 
		else {
			throw new Exception();
			//System.out.println("No available seats for this trip.");
		}
}*/


/*public Citizen signIn(String email, String password) throws Exception {

System.out.println("Received email: " + email);
System.out.println("Received password: " + password);


   
Citizen citizen = citizenRepository.findByEmail(email);


System.out.println("Retrieved Citizen: " + citizen);

// Check if the citizen exists and the password matches
if (citizen != null && citizen.getPassword().equals(password)) {
    return citizen;
} else {
    // If no matching citizen is found or the password is incorrect, return null
    return null;
}
}*/


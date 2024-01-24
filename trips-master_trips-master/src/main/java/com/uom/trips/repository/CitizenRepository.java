package com.uom.trips.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uom.trips.model.Citizen;

public interface CitizenRepository extends JpaRepository<Citizen, Integer>{
	
	Citizen findByEmail(String email);
	
	//Citizen findById(int citizenId);
	
	//Optional<Citizen> findByIdOptional (int citizenId);
	
	Citizen findByAfm (String afm);
}


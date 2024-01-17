package com.uom.trips.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uom.trips.model.Agency;

public interface AgencyRepository extends JpaRepository<Agency, Integer>{
	
	Agency findByAfm(String afm);
	
	Optional<Agency> findById(int agencyId);

}

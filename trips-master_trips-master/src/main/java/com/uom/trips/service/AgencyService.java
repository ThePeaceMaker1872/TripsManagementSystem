package com.uom.trips.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uom.trips.model.Agency;
import com.uom.trips.repository.AgencyRepository;

@Service
public class AgencyService {
	
	@Autowired
	private AgencyRepository agencyRepository;
	
	
	
	public void	registerAgency(Agency agency) throws Exception{
		agencyRepository.save(agency);
	}
}

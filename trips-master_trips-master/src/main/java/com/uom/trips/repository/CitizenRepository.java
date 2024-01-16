package com.uom.trips.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uom.trips.model.Citizen;

public interface CitizenRepository extends JpaRepository<Citizen, Integer>{

}

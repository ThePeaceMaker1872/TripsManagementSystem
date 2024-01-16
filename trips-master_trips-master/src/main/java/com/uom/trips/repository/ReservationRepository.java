package com.uom.trips.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uom.trips.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer>{

}



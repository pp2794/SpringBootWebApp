package com.piy.springBootWebApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piy.springBootWebApp.model.Shipwreck;

public interface ShipwreckRepo extends JpaRepository<Shipwreck, Long>{
	

}

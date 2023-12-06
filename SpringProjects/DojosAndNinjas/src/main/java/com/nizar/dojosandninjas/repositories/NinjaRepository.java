package com.nizar.dojosandninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nizar.dojosandninjas.models.Ninja;

public interface NinjaRepository extends CrudRepository<Ninja, Long> {
	
	// this method retrieves all the ninja from the database
	List<Ninja> findAll();
}

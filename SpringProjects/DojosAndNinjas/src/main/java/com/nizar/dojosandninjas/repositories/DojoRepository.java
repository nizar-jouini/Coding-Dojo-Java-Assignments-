package com.nizar.dojosandninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nizar.dojosandninjas.models.Dojo;

public interface DojoRepository extends CrudRepository<Dojo, Long> {
	// this method retrieves all the dojos from the database
	List<Dojo> findAll();
}

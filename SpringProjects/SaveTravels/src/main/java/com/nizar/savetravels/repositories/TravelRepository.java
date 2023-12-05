package com.nizar.savetravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nizar.savetravels.models.Travel;

public interface TravelRepository extends CrudRepository<Travel, Long> {
	// this method retrieves all the books from the database
    List<Travel> findAll();
    // this method finds books with descriptions containing the search string
    List<Travel> findByDescriptionContaining(String search);
}

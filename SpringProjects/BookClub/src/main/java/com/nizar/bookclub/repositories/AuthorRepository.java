package com.nizar.bookclub.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nizar.bookclub.models.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

	// READ ALL
	List<Author> findAll();
}

package com.nizar.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nizar.bookclub.models.Author;
import com.nizar.bookclub.repositories.AuthorRepository;

@Service
public class AuthorService {

//	C R U D

	@Autowired
	private AuthorRepository authorRepo;

//		READ ALL
	public List<Author> allAuthors() {
		return authorRepo.findAll();
	}

//		CREATE
	public Author createAuthor(Author p) {
		return authorRepo.save(p);
	}

//		READ ONE
	public Author findAuthor(Long id) {
		Optional<Author> maybeAuthor = authorRepo.findById(id);
		if (maybeAuthor.isPresent()) {
			return maybeAuthor.get();
		} else {
			return null;
		}
	}

//		UPDATE
	public Author updateAuthor(Author p) {
		return authorRepo.save(p);
	}

//		DELETE
	public void deleteAuthor(Long id) {
		authorRepo.deleteById(id);
	}
}

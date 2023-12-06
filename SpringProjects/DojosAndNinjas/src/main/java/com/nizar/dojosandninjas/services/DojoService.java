package com.nizar.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nizar.dojosandninjas.models.Dojo;
import com.nizar.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {
	
	// adding the Dojo repository as a dependency
	private final DojoRepository dojoRepository;

	public DojoService(DojoRepository dojoRepository) {
		
		this.dojoRepository = dojoRepository;
	}
	
	// return all dojos
	public List<Dojo> allDojos() {	
		return dojoRepository.findAll();
	}
	
	// create a dojo
	public Dojo createDojo(Dojo D) {
		return dojoRepository.save(D);
	}
	
	// retrieve a dojo
	public Dojo findOneDojo(Long id) {
		Optional<Dojo> oneDojo = dojoRepository.findById(id);
		if (oneDojo.isPresent()) {
			return oneDojo.get();
		} else {
			return null;
		}
	}
	
}

















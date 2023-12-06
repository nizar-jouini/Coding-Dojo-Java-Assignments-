package com.nizar.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nizar.dojosandninjas.models.Ninja;
import com.nizar.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	
	// adding the Ninja repository as a dependency
	private final NinjaRepository ninjaRepository;

	public NinjaService(NinjaRepository ninjaRepository) {
		
		this.ninjaRepository = ninjaRepository;
	}
	
	// return all ninjas
	public List<Ninja> allNinjas() {
		return ninjaRepository.findAll();
	}
	
	// create a ninja
	public Ninja createNinja(Ninja N) {
		return ninjaRepository.save(N);
	}
	
	// retrieve a ninja
	public Ninja fondOneNinja(Long id) {
		Optional<Ninja> oneNinja = ninjaRepository.findById(id);
		if (oneNinja.isPresent()) {
			return oneNinja.get();
		} else {
			return null;
		}
	}

}














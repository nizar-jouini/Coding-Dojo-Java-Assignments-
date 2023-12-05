package com.nizar.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nizar.savetravels.models.Travel;
import com.nizar.savetravels.repositories.TravelRepository;

@Service
public class TravelService {
	
	// adding the Travel repository as a dependency
	private final TravelRepository travelRepository;

	public TravelService(TravelRepository travelRepository) {
		this.travelRepository = travelRepository;
	}
	
	// return all travels
	public List<Travel> allTravels() {
		return travelRepository.findAll();
	}
	
	// create a travel
	public Travel createTravel(Travel T) {
		return travelRepository.save(T);
	}
	
	// retrieve a travel
	public Travel findTravel(Long id) {
		Optional<Travel> optionalTravel = travelRepository.findById(id);
		if (optionalTravel.isPresent()) {
			return optionalTravel.get();
		} else {
			return null;
		}
	}
	
	// update a travel
	public Travel updateTravel(Travel travel) {
		return travelRepository.save(travel);
	}
	
	// delete a travel
	public void deleteTravel(Long id) {
		Optional<Travel> optionalTravel = travelRepository.findById(id);
		if (optionalTravel.isPresent()) {
			travelRepository.deleteById(id);
		}
	}
	
}















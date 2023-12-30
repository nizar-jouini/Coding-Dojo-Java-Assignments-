package com.nizar.gameworkshop2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nizar.gameworkshop2.models.GameMechanic;
import com.nizar.gameworkshop2.repositories.GameMechanicRepository;

@Service
public class GameMechanicService {

//	C R U D

	@Autowired
	private GameMechanicRepository gameMechanicRepo;

//	READ ALL Game Mechanics
	public List<GameMechanic> allGameMechanics() {		
		return gameMechanicRepo.findAll();
	}

//	CREATE Game Mechanic
	public GameMechanic createGameMechanic(GameMechanic gm) {
		return gameMechanicRepo.save(gm);
	}

//	DELETE A Game Mechanic
	public void deleteGameMechanic(Long id) {
		gameMechanicRepo.deleteById(id);
	}
}



















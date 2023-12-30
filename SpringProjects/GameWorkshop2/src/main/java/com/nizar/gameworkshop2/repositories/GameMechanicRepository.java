package com.nizar.gameworkshop2.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nizar.gameworkshop2.models.GameMechanic;

@Repository
public interface GameMechanicRepository extends CrudRepository<GameMechanic, Long> {

//	Read ALL
	List<GameMechanic> findAll();
}

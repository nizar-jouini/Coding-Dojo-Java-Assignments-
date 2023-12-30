package com.nizar.gameworkshop2.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nizar.gameworkshop2.models.Game;

@Repository
public interface GameRepository extends CrudRepository<Game, Long> {

//	Read ALL
	List<Game> findAll();
}

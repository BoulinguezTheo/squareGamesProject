package com.example.squaregamesspring.dao.repository;

import com.example.squaregamesspring.dto.GameEntity;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<GameEntity, String> {

}

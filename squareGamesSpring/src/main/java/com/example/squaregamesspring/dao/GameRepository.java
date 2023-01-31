package com.example.squaregamesspring.dao;

import com.example.squaregamesspring.dto.GameEntity;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<GameEntity, String> {

}

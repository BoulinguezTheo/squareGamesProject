package com.example.squaregamesspring.dao;

import com.example.squaregamesspring.dto.SaveCreateGameDto;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<SaveCreateGameDto, String> {

}

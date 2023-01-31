package com.example.squaregamesspring.dao;

import com.example.squaregamesspring.dto.SaveTokenEntity;
import org.springframework.data.repository.CrudRepository;

public interface TokenRepository extends CrudRepository<SaveTokenEntity, String> {

}

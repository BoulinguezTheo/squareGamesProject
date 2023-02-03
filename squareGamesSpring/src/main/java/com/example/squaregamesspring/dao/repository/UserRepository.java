package com.example.squaregamesspring.dao.repository;

import com.example.squaregamesspring.dto.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    UserEntity findByUsername(String userName);
}

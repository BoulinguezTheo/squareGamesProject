package com.example.squaregamesspring.security;

import com.example.squaregamesspring.dao.repository.UserRepository;
import com.example.squaregamesspring.dto.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepo;
    @Override
    public UserDetails loadUserByUsername(final String username){
        UserEntity user = userRepo.findByUsername(username);
        return user;
    }
}

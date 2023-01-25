package com.example.squaregamesspring.service;

import com.example.squaregamesspring.dto.CreateGameDto;
import com.example.squaregamesspring.dto.GameDto;
import com.example.squaregamesspring.model.GameInProgress;
import org.springframework.stereotype.Service;

@Service
public interface CreateGameService {
    public GameInProgress createGame(CreateGameDto pParams);

}

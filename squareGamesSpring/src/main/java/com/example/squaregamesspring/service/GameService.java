package com.example.squaregamesspring.service;

import com.example.squaregamesspring.dto.MoveTokenDto;
import fr.le_campus_numerique.square_games.engine.InvalidPositionException;

public interface GameService {
    public void moveToken(MoveTokenDto pParams, int gameId) throws InvalidPositionException;
}

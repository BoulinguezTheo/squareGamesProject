package com.example.squaregamesspring.service;

import com.example.squaregamesspring.dto.MoveTokenDto;
import fr.le_campus_numerique.square_games.engine.InvalidPositionException;

import java.sql.SQLException;

public interface GameService {
    public void moveToken(MoveTokenDto pParams, String gameId) throws InvalidPositionException, SQLException;
}

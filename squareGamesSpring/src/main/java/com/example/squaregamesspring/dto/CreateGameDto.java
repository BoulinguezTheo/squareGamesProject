package com.example.squaregamesspring.dto;

import com.example.squaregamesspring.model.GameInProgress;
import com.example.squaregamesspring.service.CreateGameService;
import fr.le_campus_numerique.square_games.engine.Game;

public class CreateGameDto {
    private String gameName;
    private int playerCount;
    private int boardSize;
    public String getGameName() { return gameName; }
    public int getPlayerCount() { return playerCount; }
    public int getBoardSize() { return boardSize; }




}

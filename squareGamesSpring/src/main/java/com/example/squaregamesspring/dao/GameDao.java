package com.example.squaregamesspring.dao;

import fr.le_campus_numerique.square_games.engine.GameStatus;

import java.util.List;
import java.util.UUID;

public interface GameDao {

    public int getNumberOfPlayers();
    public void setNumberOfPlayers(int pNbPlayer);
    public int getGameId();
    public void setGameId(int pGameId);
    public String getPlayerId();
    public void setPlayerId(String pPlayerId);
    public String getCurrentPlayerId();
    public void setCurrentPlayerId(String pPlayerId);

    //TODO : might be string
    public GameStatus getGameStatus(int pGameId);
    public void setGameStatus(GameStatus pGameStatus);
    public void setCreatedAt(String pDate);
    public void setUpdatedAt(String pDate);
    public void deleteGame(int pGameId);
}

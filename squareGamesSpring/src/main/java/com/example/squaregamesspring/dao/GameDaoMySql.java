package com.example.squaregamesspring.dao;

import fr.le_campus_numerique.square_games.engine.GameStatus;

public class GameDaoMySql implements GameDao{
    private int nbPlayer;
    private int gameId;
    private String playerId;
    private String currentPlayerId;
    private GameStatus gameStatus;
    private String createdAt;
    private String updatedAt;
    @Override
    public int getNumberOfPlayers() {
        return 0;
    }

    @Override
    public void setNumberOfPlayers(int pNbPlayer) {

    }

    @Override
    public int getGameId() {
        return 0;
    }

    @Override
    public void setGameId(int pGameId) {

    }

    @Override
    public String getPlayerId() {
        return null;
    }

    @Override
    public void setPlayerId(String pPlayerId) {

    }

    @Override
    public String getCurrentPlayerId() {
        return null;
    }

    @Override
    public void setCurrentPlayerId(String pPlayerId) {

    }

    @Override
    public GameStatus getGameStatus(int pGameId) {
        return null;
    }

    @Override
    public void setGameStatus(GameStatus pGameStatus) {

    }

    @Override
    public void setCreatedAt(String pDate) {

    }

    @Override
    public void setUpdatedAt(String pDate) {

    }

    @Override
    public void deleteGame(int pGameId) {

    }
}

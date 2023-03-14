package com.example.squaregamesspring.model;


public class Board {
    private String gameId;
    private int playerCount;
    private int boardSize;
    private Player activePlayer;

    public String getGameId() {
        return gameId;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public int getBoardSize() {
        return boardSize;
    }
}

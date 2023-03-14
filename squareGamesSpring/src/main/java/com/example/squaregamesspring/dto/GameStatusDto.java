package com.example.squaregamesspring.dto;

import fr.le_campus_numerique.square_games.engine.GameStatus;

import java.util.UUID;

public class GameStatusDto {
    private GameStatus gameStatus;
    UUID playerId;

    public GameStatusDto(){}

    public GameStatusDto(GameStatus pStatus, UUID pPlayerId) {
        this.gameStatus = pStatus;
        this.playerId = pPlayerId;
    }
    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public UUID getPlayerId() {
        return playerId;
    }

    public void setPlayerId(UUID playerId) {
        this.playerId = playerId;
    }
}

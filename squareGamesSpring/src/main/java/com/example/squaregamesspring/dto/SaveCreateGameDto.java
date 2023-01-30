package com.example.squaregamesspring.dto;

import fr.le_campus_numerique.square_games.engine.GameStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="games")
public class SaveCreateGameDto {
    @Id
    private String gameId;
    private String gameName;
    private int nbPlayers;
    private String currentPlayerId;
    private String gameStatus;


    public SaveCreateGameDto() {
    }
    public SaveCreateGameDto(String gameId, String gameName, int nbPlayers, String currentPlayerId, GameStatus gameStatus) {
        this.gameId = gameId;
        this.gameName = gameName;
        this.nbPlayers = nbPlayers;
        this.currentPlayerId = currentPlayerId;
        this.gameStatus = gameStatus.toString();
    }


    public String getGameId() {
        return gameId;
    }
    public void setGameId(String gameId) {
        this.gameId = gameId;
    }
    public String getGameName() {
        return gameName;
    }
    public void setGameName(String gameName) {
        this.gameName = gameName;
    }
    public int getNbPlayers() {
        return nbPlayers;
    }
    public void setNbPlayers(int nbPlayers) {
        this.nbPlayers = nbPlayers;
    }
    public String getCurrentPlayerId() {
        return currentPlayerId;
    }
    public void setCurrentPlayerId(String currentPlayerId) {
        this.currentPlayerId = currentPlayerId;
    }
    public String getGameStatus() {
        return gameStatus;
    }
    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus.toString();
    }
}

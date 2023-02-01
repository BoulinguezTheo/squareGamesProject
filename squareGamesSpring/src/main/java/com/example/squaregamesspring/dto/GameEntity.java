package com.example.squaregamesspring.dto;

import fr.le_campus_numerique.square_games.engine.GameStatus;
import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name="games")
public class GameEntity {

    @Id
    @Column(name="game_id")
    private String gameId;
    @Column(name="game_name", nullable = false)
    private String gameName;
    @Column(name="boards_size", nullable = false)
    private int boardSize;
    @Column(name="number_of_players", nullable = false)
    private int nbPlayers;
    @Column(name="current_id_player")
    private String currentPlayerId;
    @Column(name="game_status", nullable = false)
    private String gameStatus;
    @ElementCollection
    @CollectionTable(name="players_ids")
    private List<String> playerIdsList;
    @OneToMany(mappedBy = "gameId")
    List<SaveTokenEntity> tokenList;

//CONSTRUCTORS
    public GameEntity() {
    }
    public GameEntity(String gameId, String gameName, int nbPlayers, String currentPlayerId, GameStatus gameStatus) {
        this.gameId = gameId;
        this.gameName = gameName;
        this.nbPlayers = nbPlayers;
        this.currentPlayerId = currentPlayerId;
        this.gameStatus = gameStatus.toString();
    }

//GETTERS AND SETTERS
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
    public void setBoardSize(int boardSize){ this.boardSize = boardSize; }
    public int getBoardSize(){ return this.boardSize; }
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
    public void setPlayersIdList(List<String> pListId){
        this.playerIdsList = pListId;
    }
    public Collection<String> getPlayersIdList(){ return this.playerIdsList; }

    public List<SaveTokenEntity> getTokenList() {
        return tokenList;
    }
    public void setTokenList(List<SaveTokenEntity> tokenList) {
        this.tokenList = tokenList;
    }
}

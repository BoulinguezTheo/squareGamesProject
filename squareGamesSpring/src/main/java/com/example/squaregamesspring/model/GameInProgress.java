package com.example.squaregamesspring.model;

import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameStatus;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class GameInProgress {
    private Game game;
    private String gameId;
    private String gameName;
    private int boardSize;
    private int nbPlayer;
    private List<String> playerIdList;
    private String currentPlayer;
    private GameStatus gameStatus;
    private List<TokenPlayed> tokenPlayedList;

    public GameInProgress(){}
    public GameInProgress(Game pGame, String pGameInProgressId, int pNbPlayers, int pBoardSize){
        this.game = pGame;
        this.gameId = pGameInProgressId;
        this.gameName = pGame.getFactoryId();
        this.playerIdList = createPlayerIdList(pGame);
        this.nbPlayer = this.playerIdList.size();
        this.currentPlayer = pGame.getCurrentPlayerId().toString();
        this.gameStatus = pGame.getStatus();
        this.tokenPlayedList = new ArrayList();
        this.nbPlayer = pNbPlayers;
        this.boardSize = pBoardSize;
    }

    private List<String> createPlayerIdList(Game pGame){
        List<String> idList = new ArrayList();
        for (UUID id : pGame.getPlayerIds()){
            idList.add(id.toString());
        }
        return idList;
    }
    public Game getGame() {
        return game;
    }
    public String getGameId() {
        return gameId;
    }
    public void setGameId(String pId){
        this.gameId = pId;
    }
    public List<TokenPlayed> getTokenPlayedList() {
        return tokenPlayedList;
    }
    public String getGameName() {
        return gameName;
    }
    public void setGameName(String pName){ this.gameName = pName;}
    public int getNbPlayer() {
        return nbPlayer;
    }
    public void setNbPlayer(int pNbPlayers){ this.nbPlayer = pNbPlayers; }
    public List<String> getPlayerIdList() {
        return playerIdList;
    }
    public String getCurrentPlayer() {
        return currentPlayer;
    }
    public void setCurrentPlayer(String pPlayerId){ this.currentPlayer = pPlayerId; }
    public GameStatus getGameStatus() {
        return gameStatus;
    }
    public void setGameStatus(String pStatus){
        gameStatus = setStatus(pStatus);
    }

    public int getBoardSize() {
        return boardSize;
    }
    public void setBoardSize(String pGameName){

    }
    private GameStatus setStatus(String pStatus){
        switch(pStatus){
            case "TERMINATED" :
                return GameStatus.TERMINATED;
            case "ONGOING" :
                return GameStatus.ONGOING;
            case "SETUP" :
                return GameStatus.SETUP;
            default :
                return null;
        }
    }
}
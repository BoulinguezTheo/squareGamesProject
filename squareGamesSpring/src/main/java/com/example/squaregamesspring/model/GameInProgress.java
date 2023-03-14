package com.example.squaregamesspring.model;

import fr.le_campus_numerique.square_games.engine.Game;

public class GameInProgress {
    private final Game game;
    private Board board;
    private final int gameId;
    private final Tokens tokens;

    public GameInProgress(Game pGame, int pGameInProgressId){
        this.game = pGame;
        this.board = new Board();
        this.gameId = pGameInProgressId;
        this.tokens = new Tokens(game.getRemainingTokens(), game.getRemovedTokens());
    }

    public Game getGame() {
        return game;
    }

    public int getGameId() {
        return gameId;
    }

    public Board getBoard() {
        return board;
    }

    public Tokens getTokens(){ return tokens; }

    public void setBoard(Board board) {
        this.board = board;
    }
}
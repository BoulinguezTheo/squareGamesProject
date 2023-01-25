package com.example.squaregamesspring.model;

import fr.le_campus_numerique.square_games.engine.Game;

import java.util.Collection;

public class GameInProgress {
    private Game game;
    private Board board;
//    private Player playerOne;
//    private Player playerTwo;
//    private Tokens tokensPlayerOne;
//    private Tokens tokensPlayerTwo;
    private int gameId;
    private Tokens tokens;


    public GameInProgress(Game pGame, int pGameInProgressId){
//        this.tokensPlayerOne = new Tokens();
//        this.tokensPlayerTwo = new Tokens();
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



//    }
//        this.tokensPlayerTwo = tokensPlayerTwo;
//    public void setTokensPlayerTwo(Tokens tokensPlayerTwo) {
//
//    }
//        return tokensPlayerTwo;
//    public Tokens getTokensPlayerTwo() {
//
//    }
//        this.tokensPlayerOne = tokensPlayerOne;
//    public void setTokensPlayerOne(Tokens tokensPlayerOne) {
//    public Tokens getTokensPlayerOne() {
//        return tokensPlayerOne;
//    }

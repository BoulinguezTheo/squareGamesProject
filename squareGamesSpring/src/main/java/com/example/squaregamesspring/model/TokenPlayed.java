package com.example.squaregamesspring.model;
import fr.le_campus_numerique.square_games.engine.Token;

public class TokenPlayed {
    private String gameId;
    private String tokenIdPlayer;
    private String tokenName;
    private int xCor;
    private int yCor;

    public TokenPlayed(String pGameId, Token token){
        this.gameId = pGameId;
        this.tokenIdPlayer = token.getOwnerId().toString();
        this.tokenName = token.getName();
        this.xCor = token.getPosition().x();
        this.yCor = token.getPosition().y();
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getTokenIdPlayer() {
        return tokenIdPlayer;
    }

    public void setTokenIdPlayer(String tokenIdPlayer) {
        this.tokenIdPlayer = tokenIdPlayer;
    }

    public String getTokenName() {
        return tokenName;
    }

    public void setTokenName(String tokenName) {
        this.tokenName = tokenName;
    }

    public int getxCor() {
        return xCor;
    }

    public void setxCor(int xCor) {
        this.xCor = xCor;
    }

    public int getyCor() {
        return yCor;
    }

    public void setyCor(int yCor) {
        this.yCor = yCor;
    }
}

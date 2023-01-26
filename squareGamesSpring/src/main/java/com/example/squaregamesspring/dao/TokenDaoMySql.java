package com.example.squaregamesspring.dao;

import fr.le_campus_numerique.square_games.engine.Token;

public class TokenDaoMySql implements TokenDao{
    private String tokenId;
    private String tokenName;
    private int xCor;
    private int yCor;
    private String gameId;
    private String tokenPlayerId;
    private String createdAt;
    private String updatedAt;
    @Override
    public Token getTokenById() {
        return null;
    }

    @Override
    public void setTokenId(String pId) {

    }

    @Override
    public String getTokenName() {
        return null;
    }

    @Override
    public void setTokenName(String pName) {

    }

    @Override
    public int getTokenXCor() {
        return 0;
    }

    @Override
    public void setTokenXCor(int pXCor) {

    }

    @Override
    public int getTokenYCor() {
        return 0;
    }

    @Override
    public void setTokenYCor(int pYCor) {

    }

    @Override
    public String getTokenGameId() {
        return null;
    }

    @Override
    public void setTokenIdGame(String pGameId) {

    }

    @Override
    public String getTokenPlayerId() {
        return null;
    }

    @Override
    public void setTokenPlayerId(String pPlayerId) {

    }

    @Override
    public void setCreatedAt(String pDate) {

    }

    @Override
    public void setUpdatedAt(String pDate) {

    }

    @Override
    public void deleteToken(int pGameId) {

    }
}

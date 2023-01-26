package com.example.squaregamesspring.dao;

import fr.le_campus_numerique.square_games.engine.Token;

public interface TokenDao {
    public Token getTokenById();
    public void setTokenId(String pId);
    public String getTokenName();
    public void setTokenName(String pName);
    public int getTokenXCor();
    public void setTokenXCor(int pXCor);
    public int getTokenYCor();
    public void setTokenYCor(int pYCor);
    public String getTokenGameId();
    public void setTokenIdGame(String pGameId);
    public String getTokenPlayerId();
    public void setTokenPlayerId(String pPlayerId);
    public void setCreatedAt(String pDate);
    public void setUpdatedAt(String pDate);
    public void deleteToken(int pGameId);

}

package com.example.squaregamesspring.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class SaveTokenDto {
    @Id
    private long tokenId;
    private String gameId;
    private String tokenName;
    private String tokenIdPlayer;
    private int xOldCor;
    private int yOldCor;
    private int xNewCor;
    private int yNewCor;

    public SaveTokenDto() {
    }
    public SaveTokenDto(long tokenId, String gameId, String tokenName, String tokenIdPlayer, int xOldCor, int yOldCor, int xNewCor, int yNewCor) {
        this.tokenId = tokenId;
        this.gameId = gameId;
        this.tokenName = tokenName;
        this.tokenIdPlayer = tokenIdPlayer;
        this.xOldCor = xOldCor;
        this.yOldCor = yOldCor;
        this.xNewCor = xNewCor;
        this.yNewCor = yNewCor;
    }

    public long getTokenId() {
        return tokenId;
    }
    public void setTokenId(long tokenId) {
        this.tokenId = tokenId;
    }
    public String getGameId() {
        return gameId;
    }
    public void setGameId(String gameId) {
        this.gameId = gameId;
    }
    public String getTokenName() {
        return tokenName;
    }
    public void setTokenName(String tokenName) {
        this.tokenName = tokenName;
    }
    public String getTokenIdPlayer() {
        return tokenIdPlayer;
    }
    public void setTokenIdPlayer(String tokenIdPlayer) {
        this.tokenIdPlayer = tokenIdPlayer;
    }
    public int getxOldCor() {
        return xOldCor;
    }
    public void setxOldCor(int xOldCor) {
        this.xOldCor = xOldCor;
    }
    public int getyOldCor() {
        return yOldCor;
    }
    public void setyOldCor(int yOldCor) {
        this.yOldCor = yOldCor;
    }
    public int getxNewCor() {
        return xNewCor;
    }
    public void setxNewCor(int xNewCor) {
        this.xNewCor = xNewCor;
    }
    public int getyNewCor() {
        return yNewCor;
    }
    public void setyNewCor(int yNewCor) {
        this.yNewCor = yNewCor;
    }
}

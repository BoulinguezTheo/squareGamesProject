package com.example.squaregamesspring.model;
import com.example.squaregamesspring.dto.MoveTokenDto;
import com.example.squaregamesspring.dto.TokenDto;
import fr.le_campus_numerique.square_games.engine.Token;

public class TokenPlayed {
    private String gameId;
    private String tokenIdPlayer;
    private String tokenName;
    private int xCor;
    private int yCor;
    private Integer yOldCor = null;
    private Integer xOldCor = null;

    public TokenPlayed(String pGameId, Token token, MoveTokenDto pTokenDto){
        this.gameId = pGameId;
        this.tokenIdPlayer = token.getOwnerId().toString();
        this.tokenName = token.getName();
        this.xCor = token.getPosition().x();
        this.yCor = token.getPosition().y();
        setxOldCor(pTokenDto.getOldX());
        setyOldCor(pTokenDto.getOldX());
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

    public Integer getyOldCor() {
        return yOldCor;
    }

    public void setyOldCor(Integer pyCor) {
        if(pyCor != null) {
            this.yOldCor = pyCor;
        }
    }

    public Integer getxOldCor() {
        return xOldCor;
    }

    public void setxOldCor(Integer pxCor) {
        if(pxCor != null) {
            this.xOldCor = yCor;
        }
    }
}

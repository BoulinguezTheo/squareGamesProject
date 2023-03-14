package com.example.squaregamesspring.dto;

import com.example.squaregamesspring.controller.CellPosition;
import com.example.squaregamesspring.model.GameInProgress;
import fr.le_campus_numerique.square_games.engine.GameStatus;
import fr.le_campus_numerique.square_games.engine.Token;

import java.util.*;

public class GameDto {

    public int gameId;
    private GameStatus gameStatus;

    private List<TokenDto> remainingTokenList;
    private List<TokenDto> removedTokenList;
    private List<TokenDto> boardTokenList;
    private List<PlayerDto> playerIdsList;


    public GameDto(GameInProgress pGame){
        this.gameName = pGame.getGame().getFactoryId();
        this.gameId = pGame.getGameId();
        this.boardSize = pGame.getGame().getBoardSize();
        this.gameStatus = pGame.getGame().getStatus();
        this.remainingTokenList = convertTokenList(pGame.getGame().getRemainingTokens());
        this.removedTokenList = convertTokenList(pGame.getGame().getRemovedTokens());
        this.boardTokenList = convertTokenBoard(pGame.getGame().getBoard());
        this.playerIdsList = convertPlayerIds(pGame.getGame().getPlayerIds());
    }

    private List<PlayerDto> convertPlayerIds(Set<UUID> pPlayerIdList){
        ArrayList<PlayerDto> idList = new ArrayList();
        for (UUID playerId : pPlayerIdList){
            PlayerDto player = new PlayerDto();
            player.setPlayerId(playerId);
            idList.add(player);
        }
        return idList;
    }
    private List<TokenDto> convertTokenBoard(Map<fr.le_campus_numerique.square_games.engine.CellPosition, Token> pTokensList){
        ArrayList<TokenDto> tokenDtoList = new ArrayList<>();
            pTokensList.values().forEach(token -> tokenDtoList.add(new TokenDto(token.getOwnerId().orElse(null).toString(), token.getName(), new CellPosition(token.getPosition().x(), token.getPosition().y()))));

        return tokenDtoList;
    }
    private List<TokenDto> convertTokenList(Collection<Token> pTokensList){
        ArrayList<TokenDto> tokenDtoList = new ArrayList<>();
        for(Token convertedToken : pTokensList) {
            if (convertedToken.getPosition() != null) {
                tokenDtoList.add(new TokenDto(convertedToken.getOwnerId().orElse(null).toString(), convertedToken.getName(), new CellPosition(convertedToken.getPosition().x(), convertedToken.getPosition().y())));
            } else {
                tokenDtoList.add(new TokenDto(convertedToken.getOwnerId().orElse(null).toString(), convertedToken.getName()));
            }
        }
        return tokenDtoList;
    }
    public List<TokenDto> getRemainingTokenList() {
        return remainingTokenList;
    }
    public List<TokenDto> getRemovedTokenList() {
        return removedTokenList;
    }

    public List<TokenDto> getBoardTokenList() {
        return boardTokenList;
    }

    public int getGameId() {
        return gameId;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public List<PlayerDto> getPlayerIdsList() {
        return playerIdsList;
    }

}

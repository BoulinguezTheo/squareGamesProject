package com.example.squaregamesspring.controller;

import com.example.squaregamesspring.dto.*;
import com.example.squaregamesspring.model.GameInProgress;
import com.example.squaregamesspring.model.GamesInProgressStorage;
import com.example.squaregamesspring.service.GameService;
import com.example.squaregamesspring.service.CreateGamesImpl;
import com.example.squaregamesspring.service.CreateGameService;
import com.example.squaregamesspring.service.GameServiceImpl;
import fr.le_campus_numerique.square_games.engine.GameStatus;
import fr.le_campus_numerique.square_games.engine.InvalidPositionException;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
public class GameController {
    CreateGameService createGame;
    GameService board;
    GameInProgress gameInProgress;
    GamesInProgressStorage.GamesStorage storage;
    public GameController(){
        this.createGame = new CreateGamesImpl();
        this.board = new GameServiceImpl();
    }
    @PostMapping("/games")
    public GameDto createGame(@RequestBody CreateGameDto pParams){
        gameInProgress = createGame.createGame(pParams);
        GameDto gameDto = new GameDto(gameInProgress);
        return gameDto;
    }

    @PutMapping ("/games/{gameId}/movetoken")
    public boolean getTokensBoard(@RequestBody MoveTokenDto pParams, @PathVariable("gameId") int gameId) {
        try{
            board.moveToken(pParams, gameId);
            //TODO : return token with its new position
            return true;
        }catch (InvalidPositionException e){
            //TODO : return token with its old position
            return false;
        }
    }

    @GetMapping("/games/{gameId}")
    public GameDto getGame(@PathVariable("gameId") int gameId){
        return new GameDto(storage.getGameById(gameId));
    }

    @GetMapping("/games/{gameId}/remainingtokens")
    public List<TokenDto> getRemainingTokens(@PathVariable("gameId") int gameId){
        return new GameDto(storage.getGameById(gameId)).getRemainingTokenList();
    }

    @GetMapping("/games/{gameId}/removedtokens")
    public List<TokenDto> getTokensRemoved(@PathVariable("gameId") int gameId){
        return new GameDto(storage.getGameById(gameId)).getRemovedTokenList();
    }

    @GetMapping("/games/{gameId}/boardtokens")
    public List<TokenDto> getTokensBoard(@PathVariable("gameId") int gameId){
        return new GameDto(storage.getGameById(gameId)).getBoardTokenList();
    }

    @GetMapping("/games/{gameId}/status")
    public GameStatus getStatus(@PathVariable("gameId") int gameId){
        return new GameDto(storage.getGameById(gameId)).getGameStatus();
    }

    @GetMapping("/games/{gameId}/playersids")
    public List<PlayerDto> getPlayerIds(@PathVariable("gameId") int gameId){
        return new GameDto(storage.getGameById(gameId)).getPlayerIdsList();
    }
    @GetMapping("/games/{gameId}/currentplayerid")
    public PlayerDto getCurrentPlayerId(@PathVariable("gameId") int gameId){
        PlayerDto currentPlayer = new PlayerDto();
        currentPlayer.setPlayerId(storage.getGameById(gameId).getGame().getCurrentPlayerId());
        return currentPlayer;
    }

    @GetMapping("/games/{gameId}/refresh")
    public PlayerDto getRefresh(@PathVariable("gameId") int gameId){
        PlayerDto currentPlayer = new PlayerDto();
        currentPlayer.setPlayerId(storage.getGameById(gameId).getGame().getCurrentPlayerId());
        return currentPlayer;
    }

}

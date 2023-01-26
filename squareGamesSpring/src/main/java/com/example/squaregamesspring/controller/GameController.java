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
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {
    @Autowired
    CreateGameService createGame;
    @Autowired
    GameService board;
    GameInProgress gameInProgress;
    GamesInProgressStorage.GamesStorage storage;
    public GameController(){
//        this.createGame = new CreateGamesImpl();
//        this.board = new GameServiceImpl();
    }
    @PostMapping("")
    public GameDto createGame(@RequestBody CreateGameDto pParams){
        gameInProgress = createGame.createGame(pParams);
        GameDto gameDto = new GameDto(gameInProgress);
        return gameDto;
    }

    @PutMapping ("/{gameId}/movetoken")
    public boolean getTokensBoard(@RequestBody MoveTokenDto pParams, @PathVariable("gameId") int gameId) {
        try{
            board.moveToken(pParams, gameId);
            return true;
        }catch (InvalidPositionException e){
            return false;
        }
    }

    @GetMapping("/{gameId}")
    public GameDto getGame(@PathVariable("gameId") int gameId){
        return new GameDto(storage.getGameById(gameId));
    }

    @GetMapping("/{gameId}/remainingtokens")
    public List<TokenDto> getRemainingTokens(@PathVariable("gameId") int gameId){
        return new GameDto(storage.getGameById(gameId)).getRemainingTokenList();
    }

    @GetMapping("/{gameId}/removedtokens")
    public List<TokenDto> getTokensRemoved(@PathVariable("gameId") int gameId){
        return new GameDto(storage.getGameById(gameId)).getRemovedTokenList();
    }

    @GetMapping("/{gameId}/boardtokens")
    public List<TokenDto> getTokensBoard(@PathVariable("gameId") int gameId){
        return new GameDto(storage.getGameById(gameId)).getBoardTokenList();
    }

    @GetMapping("/{gameId}/status")
    public GameStatusDto getStatus(@PathVariable("gameId") int gameId){
        return new GameStatusDto(storage.getGameById(gameId).getGame().getStatus(), storage.getGameById(gameId).getGame().getCurrentPlayerId());
    }

    @GetMapping("/{gameId}/playersids")
    public List<PlayerDto> getPlayerIds(@PathVariable("gameId") int gameId){
        return new GameDto(storage.getGameById(gameId)).getPlayerIdsList();
    }
    @GetMapping("/{gameId}/currentplayerid")
    public PlayerDto getCurrentPlayerId(@PathVariable("gameId") int gameId){
        PlayerDto currentPlayer = new PlayerDto();
        currentPlayer.setPlayerId(storage.getGameById(gameId).getGame().getCurrentPlayerId());
        return currentPlayer;
    }

    @GetMapping("/{gameId}/refresh")
    public PlayerDto refresh(@PathVariable("gameId") int gameId){
        return getCurrentPlayerId(gameId);
    }

}

package com.example.squaregamesspring.controller;

import com.example.squaregamesspring.dto.*;
import com.example.squaregamesspring.model.GameInProgress;
import com.example.squaregamesspring.model.GamesInProgressStorage;
import com.example.squaregamesspring.service.GameService;
import com.example.squaregamesspring.service.CreateGameService;
import fr.le_campus_numerique.square_games.engine.InvalidPositionException;
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

    public GameController(){}

    @PostMapping("")
    public GameDto createGame(@RequestBody CreateGameDto pParams){
        gameInProgress = createGame.createGame(pParams);
        return new GameDto(gameInProgress);
    }

    @PutMapping ("/{gameId}/move-token")
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
        return new GameDto(GamesInProgressStorage.GamesStorage.getGameById(gameId));
    }

    @GetMapping("/{gameId}/remaining-tokens")
    public List<TokenDto> getRemainingTokens(@PathVariable("gameId") int gameId){
        return new GameDto(GamesInProgressStorage.GamesStorage.getGameById(gameId)).getRemainingTokenList();
    }

    @GetMapping("/{gameId}/removed tokens")
    public List<TokenDto> getTokensRemoved(@PathVariable("gameId") int gameId){
        return new GameDto(GamesInProgressStorage.GamesStorage.getGameById(gameId)).getRemovedTokenList();
    }

    @GetMapping("/{gameId}/board-tokens")
    public List<TokenDto> getTokensBoard(@PathVariable("gameId") int gameId){
        return new GameDto(GamesInProgressStorage.GamesStorage.getGameById(gameId)).getBoardTokenList();
    }

    @GetMapping("/{gameId}/status")
    public GameStatusDto getStatus(@PathVariable("gameId") int gameId){
        return new GameStatusDto(GamesInProgressStorage.GamesStorage.getGameById(gameId).getGame().getStatus(),
                storage.getGameById(gameId).getGame().getCurrentPlayerId());
    }

    @GetMapping("/{gameId}/players")
    public List<PlayerDto> getPlayerIds(@PathVariable("gameId") int gameId){
        return new GameDto(storage.getGameById(gameId)).getPlayerIdsList();
    }

    @GetMapping("/{gameId}/current-player-id")
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

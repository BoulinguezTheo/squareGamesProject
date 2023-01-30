package com.example.squaregamesspring.controller;

import com.example.squaregamesspring.dao.GameRepository;
import com.example.squaregamesspring.dto.*;
import com.example.squaregamesspring.model.GameInProgress;
import com.example.squaregamesspring.model.GamesInProgressStorage;
import com.example.squaregamesspring.service.*;
import fr.le_campus_numerique.square_games.engine.InvalidPositionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {
    @Autowired
    GameRepository gameRepository;
    @Autowired
    CreateGameService createGame;
    @Autowired
    MoveTokenService board;
    @Autowired
    ReloadGameService reloading;
    GameInProgress gameInProgress;
    GamesInProgressStorage.GamesStorage storage;
    public GameController(){
//        this.createGame = new CreateGamesImpl();
//        this.board = new GameServiceImpl();
    }
    @PostMapping("")
    public GameDto createGame(@RequestBody CreateGameDto pParams) throws SQLException {
        gameInProgress = createGame.createGame(pParams, gameRepository);
        GameDto gameDto = new GameDto();
        gameDto.setGameId(gameInProgress.getGameId());
        gameDto.setGameName(gameInProgress.getGameName());
        gameDto.setBoardSize(gameInProgress.getBoardSize());
        return gameDto;
    }

    @PutMapping ("/{gameId}/movetoken")
    public boolean getTokensBoard(@RequestBody MoveTokenDto pParams, @PathVariable("gameId") String gameId) {
        try{
            board.moveToken(pParams, gameId);
            return true;
        }catch (InvalidPositionException e){
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{gameId}")
    public GameDto getGame(@PathVariable("gameId") String gameId){
        return new GameDto(storage.getGameById(gameId));
    }

    @GetMapping("/{gameId}/remainingtokens")
    public List<TokenDto> getRemainingTokens(@PathVariable("gameId") String gameId){
        return new GameDto(storage.getGameById(gameId)).getRemainingTokenList();
    }

    @GetMapping("/{gameId}/removedtokens")
    public List<TokenDto> getTokensRemoved(@PathVariable("gameId") String gameId){
        return new GameDto(storage.getGameById(gameId)).getRemovedTokenList();
    }

    @GetMapping("/{gameId}/boardtokens")
    public List<TokenDto> getTokensBoard(@PathVariable("gameId") String gameId){
        return new GameDto(storage.getGameById(gameId)).getBoardTokenList();
    }

    @GetMapping("/{gameId}/status")
    public GameStatusDto getStatus(@PathVariable("gameId") String gameId){
        return new GameStatusDto(storage.getGameById(gameId).getGame().getStatus(), storage.getGameById(gameId).getGame().getCurrentPlayerId());
    }

    @GetMapping("/{gameId}/playersids")
    public List<PlayerDto> getPlayerIds(@PathVariable("gameId") String gameId){
        return new GameDto(storage.getGameById(gameId)).getPlayerIdsList();
    }
    @GetMapping("/{gameId}/currentplayerid")
    public PlayerDto getCurrentPlayerId(@PathVariable("gameId") String gameId){
        PlayerDto currentPlayer = new PlayerDto();
        currentPlayer.setPlayerId(storage.getGameById(gameId).getGame().getCurrentPlayerId());
        return currentPlayer;
    }

    @GetMapping("/{gameId}/refresh")
    public PlayerDto refresh(@PathVariable("gameId") String gameId){
        return getCurrentPlayerId(gameId);
    }

//    @GetMapping("/{gameId}/reload")
//    public GameDto reloadGame(@PathVariable("gameId") String gameId) throws SQLException {
//        GameInProgress gameReloaded = reloading.reloadGame(gameId);
//        //TODO : reload players
//        //TODO : reload tokens
//        GameDto game = new GameDto();
//        game.setGameId(gameReloaded.getGameId());
//        game.setGameName(gameReloaded.getGameName());
//        game.setGameStatus(gameReloaded.getGameStatus());
//        game.setBoardSize(gameReloaded.getGame().getBoardSize());
//        return game;
//    }

}

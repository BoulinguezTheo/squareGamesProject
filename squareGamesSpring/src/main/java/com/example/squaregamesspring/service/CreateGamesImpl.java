package com.example.squaregamesspring.service;

import com.example.squaregamesspring.dto.CreateGameDto;
import com.example.squaregamesspring.model.GameInProgress;
import com.example.squaregamesspring.model.GamesInProgressStorage;
import com.example.squaregamesspring.plugins.*;
import fr.le_campus_numerique.square_games.engine.Game;
import org.springframework.stereotype.Service;

@Service
public class CreateGamesImpl implements CreateGameService {
    GamesInProgressStorage.GamesStorage storage = new GamesInProgressStorage.GamesStorage();
    private static int gameInProgressId = 0;

    @Override
    public GameInProgress createGame(CreateGameDto pParams) {
        Game game;
        switch(pParams.getGameName()) {
            case "tictactoe" -> game = new TicTacToePlugin().createGame();
            case "taquin" -> game = new TaquinPlugin().createGame();
            case "connectFour" -> game = new ConnectFourPlugin().createGame();
            default -> game = null;
        }

        if(game != null){
            gameInProgressId++;
            GameInProgress newGame = new GameInProgress(game, gameInProgressId);
            storage.addGameInStorage(newGame, gameInProgressId);
            return newGame;
        }else {
            return null;
        }
    }
}

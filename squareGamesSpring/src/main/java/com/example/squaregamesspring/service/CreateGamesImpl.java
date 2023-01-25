package com.example.squaregamesspring.service;

import com.example.squaregamesspring.dto.CreateGameDto;
import com.example.squaregamesspring.model.GameInProgress;
import com.example.squaregamesspring.model.GamesInProgressStorage;
import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import fr.le_campus_numerique.square_games.engine.taquin.TaquinGameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.stereotype.Service;

@Service
public class CreateGamesImpl implements CreateGameService {
    GamesInProgressStorage.GamesStorage storage = new GamesInProgressStorage.GamesStorage();
    private GameFactory gameFactory;
    private Game game;
    private GameInProgress newGame;
    private static int gameInProgressId = 0;

    @Override
    public GameInProgress createGame(CreateGameDto pParams) {
        switch (pParams.getGameName()) {
            case "tictactoe" -> gameFactory = new TicTacToeGameFactory();
            case "taquin" -> gameFactory = new TaquinGameFactory();
            case "connect4" -> gameFactory = new ConnectFourGameFactory();
        }
        game = (gameFactory.createGame(pParams.getPlayerCount(), pParams.getBoardSize()));

        gameInProgressId++;
        newGame = new GameInProgress(game, gameInProgressId);
        storage.addGameInStorage(newGame, gameInProgressId);
        return newGame;
    }
}

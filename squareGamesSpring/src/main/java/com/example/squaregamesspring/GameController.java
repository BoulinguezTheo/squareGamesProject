package com.example.squaregamesspring;

import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import fr.le_campus_numerique.square_games.engine.taquin.TaquinGameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class GameController {
    private GameFactory gameFactory;
    private Game game;
    @PostMapping("/games")
    public Game createGame(@RequestBody GameCreationParams pParams){
        switch (pParams.getGameId()){
            case "tictactoe" -> gameFactory = new TicTacToeGameFactory();
            case "taquin" -> gameFactory = new TaquinGameFactory();
            case "connect4" -> gameFactory = new ConnectFourGameFactory();
        }
        game = gameFactory.createGame(pParams.getPlayerCount(), pParams.getBoardSize());
        return game;
    }

}

package com.example.squaregamesspring.plugins;

import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Locale;
@Component
public class ConnectFourPlugin implements GamePlugin{
    @Value("${game.connectfour.default-player-count}")
    private int nbPlayers;
    @Value("${game.connectfour.default-board-size}")
    private int boardSize;
    @Override
    public Game createGame() {
        GameFactory gameFactory = new ConnectFourGameFactory();
        return (gameFactory.createGame(nbPlayers, boardSize));
    }

    @Override
    public String getName(Locale pLanguage) {
        return null;
    }
}

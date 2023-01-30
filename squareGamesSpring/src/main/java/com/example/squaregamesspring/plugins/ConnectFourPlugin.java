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
    @Value("${connectfour.default-player-count")
    private String nbPlayers;
    @Value("${connectfour.default-board-size}")
    private String boardSize;

    @Value("${connectfour.default-name}")
    private String name;

    public ConnectFourPlugin() {
    }
    @Override
    public Game createGame() {
        GameFactory gameFactory = new ConnectFourGameFactory();
        return (gameFactory.createGame(Integer.parseInt(nbPlayers), Integer.parseInt(boardSize)));
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public int getBoardSize(){ return Integer.parseInt(boardSize); }
    @Override
    public int getNbPlayers(){ return Integer.parseInt(nbPlayers); }
}

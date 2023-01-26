package com.example.squaregamesspring.plugins;

import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import fr.le_campus_numerique.square_games.engine.taquin.TaquinGameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Locale;
@Component
public class TaquinPlugin implements GamePlugin{
    @Value("${taquin.default-player-count")
    private String nbPlayers;
    @Value("${taquin.default-board-size}")
    private String boardSize;
    @Value("${taquin.default-name}")
    private String name;

    public TaquinPlugin() {
    }

    @Override
    public Game createGame() {
        GameFactory gameFactory = new TaquinGameFactory();
        return (gameFactory.createGame(Integer.parseInt(nbPlayers), Integer.parseInt(boardSize)));
    }

    @Override
    public String getName() {
        return name;
    }
}

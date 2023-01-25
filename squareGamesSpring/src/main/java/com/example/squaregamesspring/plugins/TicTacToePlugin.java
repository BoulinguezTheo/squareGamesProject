package com.example.squaregamesspring.plugins;

import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class TicTacToePlugin implements GamePlugin{
    @Value("${tictactoe.default-player-count}")
    private String nbPlayers;
    @Value("${tictactoe.default-board-size}")
    private String boardSize;
//    @Autowired
//    private MessageSource message;

//    public TicTacToePlugin(){
//        this.message = new MessageSource();
//    }
    @Override
    public Game createGame() {
        GameFactory gameFactory = new TicTacToeGameFactory();
        return (gameFactory.createGame(Integer.parseInt(nbPlayers), Integer.parseInt(boardSize)));
    }

    @Override
    public String getName(Locale pLanguage) {
        return null;
    }
}

package com.example.squaregamesspring;

import fr.le_campus_numerique.square_games.engine.GameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class GamaCatalogDummyImpl implements GameCatalog {
    GameFactory factory = new TicTacToeGameFactory();
    @Override
    public Collection<String> getGameIdentifiers() {
        Collection<String> list = new ArrayList<>();
        list.add(factory.getId());
        return list;
    }
}

//package com.example.squaregamesspring.intro;
//
//import fr.le_campus_numerique.square_games.engine.GameFactory;
//import fr.le_campus_numerique.square_games.engine.taquin.TaquinGameFactory;
//import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Collection;
//
//@Service
//public class GamaCatalogDummyImpl {
//    GameFactory tictactoeFactory = new TicTacToeGameFactory();
//    GameFactory taquinFactory = new TaquinGameFactory();
//    public Collection<String> getGameIdentifiers() {
//        Collection<String> list = new ArrayList<>();
//        list.add(tictactoeFactory.getGameId());
//        list.add(taquinFactory.getGameId());
//        return list;
//    }
//
//}

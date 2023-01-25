package com.example.squaregamesspring.model;

import fr.le_campus_numerique.square_games.engine.Game;

import java.util.HashMap;
import java.util.Map;

public class GamesInProgressStorage {

    public static class GamesStorage{
        static Map<Integer, GameInProgress> storage = new HashMap();

        public void addGameInStorage(GameInProgress pGame, int pId){
            storage.put(pId, pGame);
        }
        public Map getStorage(){
            return storage;
        }

        public static GameInProgress getGameById(int pId){
            return storage.get(pId);
        }

    }
}

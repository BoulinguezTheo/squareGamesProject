package com.example.squaregamesspring.model;

import fr.le_campus_numerique.square_games.engine.Game;

import java.util.HashMap;
import java.util.Map;

public class GamesInProgressStorage {

    public static class GamesStorage{
        static Map<String, GameInProgress> storage = new HashMap();

        public void addGameInStorage(GameInProgress pGame, String pId){
            storage.put(pId, pGame);
        }
        public Map getStorage(){
            return storage;
        }

        public static GameInProgress getGameById(String pId){
            return storage.get(pId);
        }

    }
}

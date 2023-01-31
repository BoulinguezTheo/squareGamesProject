package com.example.squaregamesspring.dao;

import com.example.squaregamesspring.dto.GameEntity;
import com.example.squaregamesspring.model.GameInProgress;

public interface GameDao {
    public void saveGame(GameInProgress pGame);
    public GameEntity reloadGame(String pId);

//    public void saveGame(SaveCreateGameDto pGameDto) throws SQLException;
//    public void savePlayers(GameInProgress pGame) throws SQLException;
//    public GameInProgress reloadGame(String gameId) throws SQLException;
//    public void deleteGame(int pGameId);
}

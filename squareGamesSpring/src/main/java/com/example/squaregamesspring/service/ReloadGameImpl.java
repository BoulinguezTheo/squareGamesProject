package com.example.squaregamesspring.service;

import com.example.squaregamesspring.model.GameInProgress;
import com.example.squaregamesspring.plugins.GamePlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ReloadGameImpl implements ReloadGameService{
    @Autowired
    private List<GamePlugin> listGames;

    @Override
    public GameInProgress reloadGame(String pGameID) throws SQLException {
        return null;
    }
//    @Override
//    public GameInProgress reloadGame(String pGameID) throws SQLException {
//        GameDao reload = new GameDaoMySql();
//        //TODO : re-instantiate a "Game"
//        GameInProgress gameReload = reload.reloadGame(pGameID);
//        return gameReload;
//    }
}

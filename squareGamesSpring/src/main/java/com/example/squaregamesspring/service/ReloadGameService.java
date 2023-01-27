package com.example.squaregamesspring.service;

import com.example.squaregamesspring.model.GameInProgress;

import java.sql.SQLException;

public interface ReloadGameService {
    public GameInProgress reloadGame(String pGameID) throws SQLException;
}

package com.example.squaregamesspring.service;

import com.example.squaregamesspring.model.GameInProgress;
import fr.le_campus_numerique.square_games.engine.InconsistentGameDefinitionException;

import java.sql.SQLException;

public interface ReloadGameService {
    public GameInProgress reloadGame(String pGameID) throws SQLException, InconsistentGameDefinitionException;
}

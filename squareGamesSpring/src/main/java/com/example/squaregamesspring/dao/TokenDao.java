package com.example.squaregamesspring.dao;

import com.example.squaregamesspring.dto.SaveTokenDto;
import com.example.squaregamesspring.model.TokenPlayed;
import fr.le_campus_numerique.square_games.engine.Token;

import java.sql.SQLException;

public interface TokenDao {
    public void saveToken(SaveTokenDto pToken) throws SQLException;
    public void deleteToken(int pGameId);

}

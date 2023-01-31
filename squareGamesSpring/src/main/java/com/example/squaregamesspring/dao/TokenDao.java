package com.example.squaregamesspring.dao;

import com.example.squaregamesspring.dto.SaveTokenEntity;
import com.example.squaregamesspring.model.TokenPlayed;

import java.sql.SQLException;

public interface TokenDao {
    public void saveToken(String pGameId, TokenPlayed pTokenPlayed);

}

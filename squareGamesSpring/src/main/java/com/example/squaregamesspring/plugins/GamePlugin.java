package com.example.squaregamesspring.plugins;

import fr.le_campus_numerique.square_games.engine.Game;

import java.util.Locale;

public interface GamePlugin {
    public Game createGame();
    public String getName();
}

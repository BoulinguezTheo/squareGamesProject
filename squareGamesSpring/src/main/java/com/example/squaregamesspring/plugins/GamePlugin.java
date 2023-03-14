package com.example.squaregamesspring.plugins;

import fr.le_campus_numerique.square_games.engine.Game;

public interface GamePlugin {
    public Game createGame();
    public String getName();
}

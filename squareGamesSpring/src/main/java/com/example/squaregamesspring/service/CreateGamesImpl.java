package com.example.squaregamesspring.service;

import com.example.squaregamesspring.dto.CreateGameDto;
import com.example.squaregamesspring.model.GameInProgress;
import com.example.squaregamesspring.model.GamesInProgressStorage;
import com.example.squaregamesspring.plugins.*;
import fr.le_campus_numerique.square_games.engine.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateGamesImpl implements CreateGameService {
    GamesInProgressStorage.GamesStorage storage = new GamesInProgressStorage.GamesStorage();
    private static int gameInProgressId = 0;
    @Autowired
    private List<GamePlugin> listGames;

    @Override
    public GameInProgress createGame(CreateGameDto pParams) {
        Game game = listGames.stream()
                .filter(g -> g.getName().equals(pParams.getGameName()))
                .findFirst()
                .orElse(null)
                .createGame();

        if(game != null){
            gameInProgressId++;
            GameInProgress newGame = new GameInProgress(game, gameInProgressId);
            storage.addGameInStorage(newGame, gameInProgressId);
            return newGame;
        }else {
            return null;
        }
    }


}

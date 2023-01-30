package com.example.squaregamesspring.service;


import com.example.squaregamesspring.dao.JpaGameDao;
import com.example.squaregamesspring.dto.CreateGameDto;
import com.example.squaregamesspring.model.GameInProgress;
import com.example.squaregamesspring.model.GamesInProgressStorage;
import com.example.squaregamesspring.plugins.*;
import fr.le_campus_numerique.square_games.engine.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Service
public class CreateGamesImpl implements CreateGameService {
    GamesInProgressStorage.GamesStorage storage = new GamesInProgressStorage.GamesStorage();
    private String gameInProgressId;
    @Autowired
    private List<GamePlugin> listGames;
    @Override
    public GameInProgress createGame(CreateGameDto pParams) throws SQLException {
        Game game = listGames.stream()
                .filter(g -> g.getName().equals(pParams.getGameName()))
                .findFirst()
                .orElse(null)
                .createGame();
        int nbPlayers = listGames.stream()
                .filter(g -> g.getName().equals(pParams.getGameName()))
                .findFirst()
                .orElse(null)
                .getNbPlayers();
        int boardSize = listGames.stream()
                .filter(g -> g.getName().equals(pParams.getGameName()))
                .findFirst()
                .orElse(null)
                .getBoardSize();

        if(game != null){
            gameInProgressId =  UUID.randomUUID().toString();
            GameInProgress newGame = new GameInProgress(game, gameInProgressId, nbPlayers, boardSize);

            JpaGameDao saveJpa = new JpaGameDao();
            saveJpa.saveGame(newGame);
            storage.addGameInStorage(newGame, gameInProgressId);
            return newGame;
        }else {
            return null;
        }
    }



}

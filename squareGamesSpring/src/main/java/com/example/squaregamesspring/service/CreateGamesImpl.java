package com.example.squaregamesspring.service;

import com.example.squaregamesspring.dao.GameDao;
import com.example.squaregamesspring.dao.GameDaoMySql;
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
    private GameDao dao = new GameDaoMySql();

    @Override
    public GameInProgress createGame(CreateGameDto pParams) throws SQLException {
        Game game = listGames.stream()
                .filter(g -> g.getName().equals(pParams.getGameName()))
                .findFirst()
                .orElse(null)
                .createGame();

        if(game != null){
            gameInProgressId =  UUID.randomUUID().toString();
            GameInProgress newGame = new GameInProgress(game, gameInProgressId);
            dao.saveGame(newGame);
            dao.savePlayers(newGame);
            // oR
            storage.addGameInStorage(newGame, gameInProgressId);
            return newGame;
        }else {
            return null;
        }

    }


}

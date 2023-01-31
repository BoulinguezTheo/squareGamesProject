package com.example.squaregamesspring.service;

import com.example.squaregamesspring.dao.JpaTokenDao;
import com.example.squaregamesspring.dao.TokenDao;
import com.example.squaregamesspring.dao.MySql.TokenDaoMySql;
import com.example.squaregamesspring.dto.MoveTokenDto;
import com.example.squaregamesspring.dto.SaveTokenEntity;
import com.example.squaregamesspring.model.GamesInProgressStorage;
import com.example.squaregamesspring.model.TokenPlayed;
import fr.le_campus_numerique.square_games.engine.CellPosition;
import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.InvalidPositionException;
import fr.le_campus_numerique.square_games.engine.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class MoveTokenServiceImpl implements MoveTokenService {
    GamesInProgressStorage.GamesStorage storage;
    @Autowired
    JpaTokenDao tokenDao;
    @Override
    public void moveToken(MoveTokenDto pParams, String gameId) throws InvalidPositionException, SQLException {
        Game game = GamesInProgressStorage.GamesStorage.getGameById(gameId).getGame();
        Token token;
        if (pParams.getOldX() == null && pParams.getOldY() == null){
            token = game.getRemainingTokens().stream()
                    .findFirst()
                    .orElse(null);
        }else{
            token = game.getBoard().get(new CellPosition(pParams.getOldX(), pParams.getOldY()));
        }

        if (token != null){
            token.moveTo(new fr.le_campus_numerique.square_games.engine.CellPosition(pParams.getNewX(), pParams.getNewY()));
            TokenPlayed tokenPlayed = new TokenPlayed(gameId, token, pParams);
            storage.getGameById(gameId).getTokenPlayedList().add(tokenPlayed);
            tokenDao.saveToken(gameId, tokenPlayed, storage.getGameById(gameId));
        }
    }
}

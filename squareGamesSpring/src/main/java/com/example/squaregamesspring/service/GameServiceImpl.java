package com.example.squaregamesspring.service;

import com.example.squaregamesspring.dto.MoveTokenDto;
import com.example.squaregamesspring.model.GamesInProgressStorage;
import fr.le_campus_numerique.square_games.engine.CellPosition;
import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.InvalidPositionException;
import fr.le_campus_numerique.square_games.engine.Token;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {
    @Override
    public void moveToken(MoveTokenDto pParams, int gameId) throws InvalidPositionException {
        Game game = GamesInProgressStorage.GamesStorage.getGameById(gameId).getGame();
        Token token;
        if (pParams.getOldX() == null && pParams.getOldY() == null){
            token = game.getRemainingTokens()
                    .stream()
                    .findFirst()
                    .orElse(null);
        }else{
            token = game.getBoard().get(new CellPosition(pParams.getOldX(), pParams.getOldY()));
        }
        if (token != null){
            token.moveTo(new fr.le_campus_numerique.square_games.engine.CellPosition(pParams.getNewX(), pParams.getNewY()));
        }
    }
}

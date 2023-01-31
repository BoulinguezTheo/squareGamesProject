package com.example.squaregamesspring.dao;

import com.example.squaregamesspring.dto.GameEntity;
import com.example.squaregamesspring.model.GameInProgress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JpaGameDao implements GameDao{
    @Autowired
    GameRepository gameRepo;
    @Override
    public void saveGame(GameInProgress pGame){
        GameEntity saveGameEntity = createSaveEntity(pGame);
        gameRepo.save(saveGameEntity);
    }
    @Override
    public GameEntity reloadGame(String pId){
        return gameRepo.findById(pId).get();

    }

    private GameEntity createSaveEntity(GameInProgress pGame){
        GameEntity dto = new GameEntity();
        dto.setGameId(pGame.getGameId());
        dto.setGameName(pGame.getGameName());
        dto.setBoardSize(pGame.getBoardSize());
        dto.setNbPlayers(pGame.getNbPlayer());
        dto.setCurrentPlayerId(pGame.getCurrentPlayer());
        dto.setGameStatus(pGame.getGameStatus());
        dto.setPlayersIdList(pGame.getPlayerIdList());
        return dto;
    }
}

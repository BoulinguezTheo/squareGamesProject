package com.example.squaregamesspring.dao;

import com.example.squaregamesspring.dto.SaveCreateGameDto;
import com.example.squaregamesspring.model.GameInProgress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JpaSaveGame implements GameDao{
    @Autowired
    GameRepository gameRepo;
    public void saveGame(GameInProgress pGame){
        SaveCreateGameDto saveGameDto = createSaveDto(pGame);
        gameRepo.save(saveGameDto);
    }

    private SaveCreateGameDto createSaveDto(GameInProgress pGame){
        SaveCreateGameDto dto = new SaveCreateGameDto();
        dto.setGameId(pGame.getGameId());
        dto.setGameName(pGame.getGameName());
        dto.setNbPlayers(pGame.getNbPlayer());
        dto.setCurrentPlayerId(pGame.getCurrentPlayer());
        dto.setGameStatus(pGame.getGameStatus());
        return dto;
    }
}

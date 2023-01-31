package com.example.squaregamesspring.dao;

import com.example.squaregamesspring.dto.SaveTokenEntity;
import com.example.squaregamesspring.model.GameInProgress;
import com.example.squaregamesspring.model.TokenPlayed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JpaTokenDao {
    @Autowired
    TokenRepository tokenRepo;

    public void saveToken(String pGameId, TokenPlayed pTokenPlayed, GameInProgress pGame){
        SaveTokenEntity saveTokenEntity = createSaveTokenEntity(pGameId, pTokenPlayed, pGame);
        tokenRepo.save(saveTokenEntity);
    }

    private SaveTokenEntity createSaveTokenEntity(String pGameId, TokenPlayed pToken, GameInProgress pGame){
        SaveTokenEntity tokenEntity = new SaveTokenEntity();
        tokenEntity.setGame(pGame);
        tokenEntity.setTokenName(pToken.getTokenName());
        tokenEntity.setTokenIdPlayer(pToken.getTokenIdPlayer());
        tokenEntity.setxNewCor(pToken.getxCor());
        tokenEntity.setyNewCor(pToken.getyCor());
        tokenEntity.setxOldCor(pToken.getxOldCor());
        tokenEntity.setyOldCor(pToken.getyOldCor());
        return tokenEntity;
    }
}

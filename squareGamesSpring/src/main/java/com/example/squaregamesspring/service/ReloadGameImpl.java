package com.example.squaregamesspring.service;

import com.example.squaregamesspring.dao.JpaGameDao;
import com.example.squaregamesspring.dto.GameEntity;
import com.example.squaregamesspring.dto.SaveTokenEntity;
import com.example.squaregamesspring.model.GameInProgress;
import fr.le_campus_numerique.square_games.engine.*;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ReloadGameImpl implements ReloadGameService {
    @Autowired
    JpaGameDao reloadDao;
    @Override
    public GameInProgress reloadGame(String pGameID) throws InconsistentGameDefinitionException {
        GameEntity reloaded = reloadDao.reloadGame(pGameID);
        List<SaveTokenEntity> tokensList = reloaded.getTokenList();
        Collection<TokenPosition> managedTokens= manageTokens(tokensList);

        GameFactory factory = new TicTacToeGameFactory();
        Game game = factory.createGame(reloaded.getBoardSize(), reloaded.getPlayersIdList().stream().toList(), managedTokens ,null);

        return null;
    }

    private Collection<TokenPosition> manageTokens(List<SaveTokenEntity> pList){
        Collection<TokenPosition> returnList = new ArrayList();
        pList.stream().forEach(e -> returnList.add(new TokenPosition(e.getTokenIdPlayer(), e.getTokenName(), e.getxNewCor(), e.getyNewCor())));
        return returnList;
    }
}

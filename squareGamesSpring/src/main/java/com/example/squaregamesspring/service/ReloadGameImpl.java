package com.example.squaregamesspring.service;

import com.example.squaregamesspring.dao.JpaGameDao;
import com.example.squaregamesspring.dto.GameEntity;
import com.example.squaregamesspring.dto.SaveTokenEntity;
import com.example.squaregamesspring.model.GameInProgress;
import com.example.squaregamesspring.model.GamesInProgressStorage;
import fr.le_campus_numerique.square_games.engine.*;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;



@Service
public class ReloadGameImpl implements ReloadGameService {
    @Autowired
    JpaGameDao reloadDao;
    GamesInProgressStorage.GamesStorage storage;
    @Override
    public void reloadGame(String pGameID) throws InconsistentGameDefinitionException {
        GameEntity reloaded = reloadDao.reloadGame(pGameID);
        List<SaveTokenEntity> tokensList = reloaded.getTokenList();
//        Collection<TokenPosition<String>> managedTokens= manageTokens(tokensList);

        GameFactory factory = new TicTacToeGameFactory();
        Game game = factory.createGame(reloaded.getBoardSize(),
                reloaded.getPlayersIdList().stream().toList(),
                manageTokensBoard(tokensList) ,
                manageTokensRemoved(tokensList));
        GameInProgress reloadedGame = new GameInProgress(game, reloaded.getGameId(), reloaded.getNbPlayers(), reloaded.getBoardSize());
        storage.addGameInStorage(reloadedGame, reloadedGame.getGameId());

//        return reloadedGame;
    }

    private Collection<TokenPosition<String>> manageTokensBoard(List<SaveTokenEntity> pList){
        Collection<TokenPosition<String>> returnList = new ArrayList();
        pList.stream().forEach(e -> returnList.add(new TokenPosition<>(e.getTokenIdPlayer(), e.getTokenName(), e.getxNewCor(), e.getyNewCor())));
        return returnList;
    }
    private Collection<TokenPosition<String>> manageTokensRemoved(List<SaveTokenEntity> pList){
        Collection<TokenPosition<String>> returnList = new ArrayList();

        return returnList;
    }
}


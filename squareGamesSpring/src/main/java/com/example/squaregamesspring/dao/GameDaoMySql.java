package com.example.squaregamesspring.dao;

import com.example.squaregamesspring.model.GameInProgress;
import com.example.squaregamesspring.singleton.SingletonConnexion;
import fr.le_campus_numerique.square_games.engine.GameStatus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static java.lang.String.format;

public class GameDaoMySql implements GameDao{
    int firstPlayer = 0;
    int secondPlayer = 1;
    public void saveGame(GameInProgress pGame) throws SQLException {
        SingletonConnexion singleton = SingletonConnexion.getInstance();
//        singleton.getConnection();
        String req = format("'%s','%s', '%o', '%s', '%s'", pGame.getGameId(), pGame.getGameName(), pGame.getNbPlayer(), pGame.getCurrentPlayer(), pGame.getGameStatus().toString());
        String request = "INSERT INTO games (game_id, game_name, number_of_players, current_player_id, game_status) VALUES (" + req + ");";

        try{
            Statement stmt = singleton.getConnection().createStatement();
            stmt.executeUpdate(request);
        } catch (SQLException e){
            System.out.println(e);
        } finally {
            if(singleton.getConnection() != null && !singleton.getConnection().isClosed()) {
                singleton.closeConnection();
            }
        }
    }

    @Override
    public void savePlayers(GameInProgress pGame) throws SQLException {
        SingletonConnexion singleton = SingletonConnexion.getInstance();
        for (String playerId : pGame.getPlayerIdList()){
            String req = format("'%s', '%s'", pGame.getGameId(), playerId);
            String request = "INSERT INTO players (game_id, player_id) VALUES (" + req + ");";
            try{
                Statement stmt = singleton.getConnection().createStatement();
                stmt.executeUpdate(request);
            } catch (SQLException e){
                System.out.println(e);
            }finally {
                if(singleton != null && !singleton.getConnection().isClosed()){
                    singleton.closeConnection();
                }
            }
        }
    }

    public GameInProgress reloadGame(String gameId) throws SQLException {
        GameInProgress game = new GameInProgress();
        SingletonConnexion singleton = SingletonConnexion.getInstance();
        String request = "SELECT game_id, game_name, number_of_players, current_player_id, game_status FROM games WHERE game_id = '" + gameId + "';";
        ResultSet result = null;
        try{
            Statement stmt = singleton.getConnection().createStatement();
            result = stmt.executeQuery(request);
            while(result.next()) {
                game.setGameId(result.getString("game_id"));
                game.setGameName(result.getString("game_name"));
                game.setNbPlayer(result.getInt("number_of_players"));
                game.setCurrentPlayer(result.getString("current_player_id"));
                game.setGameStatus(result.getString("game_status"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }finally{
            if(singleton != null && SingletonConnexion.getConnection().isClosed()){
                singleton.closeConnection();
            }
        }
        return game;
    }



    @Override
    public void deleteGame(int pGameId) {

    }
}

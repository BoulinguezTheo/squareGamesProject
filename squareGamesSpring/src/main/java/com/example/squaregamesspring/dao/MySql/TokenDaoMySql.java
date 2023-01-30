package com.example.squaregamesspring.dao.MySql;

import com.example.squaregamesspring.dao.TokenDao;
import com.example.squaregamesspring.dto.SaveTokenDto;
import com.example.squaregamesspring.model.TokenPlayed;
import com.example.squaregamesspring.singleton.SingletonConnexion;
import java.sql.SQLException;
import java.sql.Statement;

import static java.lang.String.format;

public class TokenDaoMySql implements TokenDao {

    @Override
    public void saveToken(SaveTokenDto pToken) throws SQLException {
        SingletonConnexion singleton = SingletonConnexion.getInstance();

        String req = format("'%s', '%s', '%s', '%o', '%o'", pToken.getGameId(), pToken.getTokenName(), pToken.getTokenIdPlayer(), pToken.getxNewCor(), pToken.getyNewCor());
        String request = "INSERT INTO tokens (game_id, token_name, token_id_player, x_cor, y_cor) VALUES (" + req + ");";
        try{
            Statement stmt = singleton.getConnection().createStatement();
            stmt.executeUpdate(request);
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if(singleton != null && SingletonConnexion.getConnection().isClosed()){
                singleton.closeConnection();
            }
        }
    }

    @Override
    public void deleteToken(int pGameId) {

    }
}

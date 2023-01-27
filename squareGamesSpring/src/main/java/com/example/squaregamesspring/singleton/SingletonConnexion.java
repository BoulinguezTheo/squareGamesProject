package com.example.squaregamesspring.singleton;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class SingletonConnexion {
    private static SingletonConnexion INSTANCE;
    private static Connection connection;

    private SingletonConnexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static SingletonConnexion getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SingletonConnexion();
        }
        return INSTANCE;
    }

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {

                String URL = "jdbc:mysql://localhost:6603/square_games";
                String USER = "root";
                String PASSWORD = "helloworld";
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void closeConnection() throws SQLException{
        connection.close();
    }
}

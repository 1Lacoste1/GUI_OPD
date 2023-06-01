package com.example.testgui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection extends Configs {
    private static DBConnection instance = null;
    public static DBConnection getInstance() throws SQLException {
        if(null == instance)
            instance = new DBConnection();

        return instance;
    }
    public Connection getConnection() {
        Connection connection = null;
        try{
            String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
            connection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return connection;
    }

}

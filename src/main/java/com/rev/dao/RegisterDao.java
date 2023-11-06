package com.rev.dao;

import com.rev.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao {
    private static final String INSERT_NEW_USER = "INSERT INTO auth (username,password) VALUES (?,?);";
    private Connection connection;

    public RegisterDao(){
        connection = DbConnection.getConnection();
    }

    public void addUser(String username, String pass){

        try {
            PreparedStatement statement=connection.prepareStatement(INSERT_NEW_USER);
            statement.setString(1,username);
            statement.setString(2,pass);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

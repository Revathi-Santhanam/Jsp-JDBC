package com.rev.dao;

import com.rev.db.DbConnection;
import com.rev.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private static final String LOGIN_QUERY ="SELECT id,username,password FROM auth WHERE username=? AND password=?" ;
    private final Connection connection;

    public UserDao(){
        connection= DbConnection.getConnection();
    }

    public User loginUser(String username, String password){
        User user=null;
        try {
            PreparedStatement statement=connection.prepareStatement(LOGIN_QUERY);
            statement.setString(1,username);
            statement.setString(2,password);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                user=new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}

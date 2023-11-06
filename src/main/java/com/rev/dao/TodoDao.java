package com.rev.dao;

import com.rev.db.DbConnection;
import com.rev.model.Todo;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TodoDao {
    private  String INSERT_QUERY ="INSERT INTO todo (userId,item) VALUES (?,?);" ;
    private  String SELECT_ALL_QUERY = "SELECT id,item FROM todo WHERE userId=? AND d_flag=false;";
    private  String DELETE_QUERY = "UPDATE todo SET d_flag=true WHERE ID=?;";
    private Connection connection;
    public TodoDao(){
        connection= DbConnection.getConnection();
    }

    public void addTodo(String item, int userId){
        try {
            PreparedStatement statement=connection.prepareStatement(INSERT_QUERY);
            statement.setString(2,item);
            statement.setInt(1,userId);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Todo> getAllValues(int userId){
        List<Todo> todos = new ArrayList<>();
        try {
            PreparedStatement statement=connection.prepareStatement(SELECT_ALL_QUERY);
            statement.setInt(1,userId);
            ResultSet rs=statement.executeQuery();
            while (rs.next()){
                Todo todo = new Todo();
                todo.setId(rs.getInt("id"));
                todo.setItem(rs.getString("item"));
                todos.add(todo);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return todos;
    }

    public void deleteTodo(String id){
        try {
            PreparedStatement statement=connection.prepareStatement(DELETE_QUERY);
            statement.setString(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

package com.msp.dao;

import com.msp.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDaoJdbcImpl  {
//    private Connection jdbcConnection;
//
//    public UsersDaoJdbcImpl(Connection connection) {
//        jdbcConnection = connection;
//    }
//
//    public void insertUser(User user) {
//        String sql = "INSERT INTO user (name, login, password) VALUES (?, ? , ?)";
//
//        try {
//            PreparedStatement statement = jdbcConnection.prepareStatement(sql);
//            statement.setString(1, user.getName());
//            statement.setString(2, user.getLogin());
//            statement.setString(3, user.getPassword());
//
//            statement.executeUpdate();
//            statement.close();
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//
//    }
//
//    public void deleteUser(int id){
//        String sql = "DELETE from user where id = ?";
//
//        try{
//            PreparedStatement statement = jdbcConnection.prepareStatement(sql);
//            statement.setInt(1, id);
//
//            statement.executeUpdate();
//            statement.close();
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//    }
//
//    public void updateUser(User user){
//        String sql = "UPDATE user SET name = ?, login = ?, password = ? WHERE id = ?";
//
//        try{
//            PreparedStatement statement = jdbcConnection.prepareStatement(sql);
//            statement.setString(1, user.getName());
//            statement.setString(2, user.getLogin());
//            statement.setString(3, user.getPassword());
//            statement.setInt(4, user.getId());
//
//            statement.executeUpdate();
//            statement.close();
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//    }
//
//    public User getUser(int id){
//        User user = null;
//        String sql = "SELECT * FROM user WHERE id = ?";
//        try{
//            PreparedStatement statement = jdbcConnection.prepareStatement(sql);
//            statement.setInt(1, id);
//
//            ResultSet resultSet = statement.executeQuery();
//
//            if(resultSet.next()){
//                String name = resultSet.getString( "name");
//                String login = resultSet.getString( "login");
//                String password = resultSet.getString( "password");
//
//                user = new User(id, name, login, password);
//            }
//
//            resultSet.close();
//            statement.close();
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//
//        return user;
//    }
//
//    public List<User> getAllUsers(){
//        List<User> list = new ArrayList<>();
//        String sql = "SELECT * FROM user";
//
//        try{
//            PreparedStatement statement = jdbcConnection.prepareStatement(sql);
//            ResultSet resultSet = statement.executeQuery();
//
//            while (resultSet.next()){
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString( "name");
//                String login = resultSet.getString( "login");
//                String password = resultSet.getString( "password");
//                User user = new User(id, name, login, password);
//                list.add(user);
//            }
//
//            resultSet.close();
//            statement.close();
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//        return list;
//    }
}

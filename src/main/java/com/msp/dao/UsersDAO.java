package com.msp.dao;

import com.msp.model.User;

import java.util.List;

public interface UsersDAO {
    List<User> getAllUsers();
    void insertUser(User user);
    void deleteUser(int id);
    void updateUser(User user);
    User getUser(int id);
}

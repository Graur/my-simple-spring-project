package com.msp.dbService;

import com.msp.model.User;

import java.util.List;

public interface DBService {
    List<User> getAllUsers();
    void insertUser(User user);
    void deleteUser(int id);
    void updateUser(User user);
    User getUser(int id);

}
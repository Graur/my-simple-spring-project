package com.msp.dbService;

import com.msp.model.Role;
import com.msp.model.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    List<User> getAllUsers();
    void insertUser(User user);
    void deleteUser(int id);
    void updateUser(User user);
    User getUser(int id);
    Set<Role> getUserRoles(String login);
    User getUserByLogin(String login);
}
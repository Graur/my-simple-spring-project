package com.msp.dbService;

import com.msp.dao.UsersDAO;
import com.msp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DBServiceImpl implements DBService {
    @Autowired
    private UsersDAO usersDAO;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return this.usersDAO.getAllUsers();
    }

    @Override
    @Transactional
    public void insertUser(User user) {
        this.usersDAO.insertUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        this.usersDAO.deleteUser(id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        this.usersDAO.updateUser(user);
    }

    @Override
    @Transactional
    public User getUser(int id) {
        return this.usersDAO.getUser(id);
    }
}


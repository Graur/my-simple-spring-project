package com.msp.dao;

import com.msp.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsersDaoHibernateImpl implements UsersDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public List<User> getAllUsers() {
        Session session = sessionFactory.openSession();
        List<User> users = session.createQuery("FROM com.msp.model.User").list();
        session.close();
        return users;
    }

    public void insertUser(User user){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteUser(int id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user = session.load(User.class, id);
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }

    public void updateUser(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
    }

    public User getUser(int id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String queryString = "FROM com.msp.model.User WHERE id = :id";
        Query query = session.createQuery(queryString);
        query.setParameter("id", id);
        User user = (User) query.uniqueResult();
        session.close();
        return user;
    }
}

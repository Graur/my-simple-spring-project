package com.msp.dao;

import com.msp.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDAOImpl implements RoleDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Role getRoleByRoleName(String roleName) {
        Session session = sessionFactory.openSession();
        String queryString = "FROM com.msp.model.Role WHERE name = :name";
        Query query = session.createQuery(queryString);
        query.setParameter("name", roleName);
        Role role = (Role) query.uniqueResult();
        session.close();
        return role;
    }

    @Override
    public void addRole(Role role) {
        Session session = sessionFactory.openSession();
        session.save(role);
        session.close();
    }

    @Override
    public Role getRoleById(int id) {
        Session session = sessionFactory.openSession();
        String queryString = "FROM com.msp.model.Role WHERE id = :id";
        Query query = session.createQuery(queryString);
        query.setParameter("id", id);
        Role role = (Role) query.uniqueResult();
        session.close();
        return role;
    }

    @Override
    public List<Role> getAllRoles() {
        Session session = sessionFactory.openSession();
        List<Role> users = session.createQuery("FROM com.msp.model.Role").list();
        session.close();
        return users;
    }

    @Override
    public void updateRoles(Role role) {
        Session session = sessionFactory.openSession();
        session.update(role);
        session.close();
    }

    @Override
    public void deleteRoleById(int id) {
        Session session = sessionFactory.openSession();
        Role role = session.load(Role.class, id);
        session.delete(role);
        session.close();
    }
}

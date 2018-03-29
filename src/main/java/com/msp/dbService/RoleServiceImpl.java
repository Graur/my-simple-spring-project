package com.msp.dbService;

import com.msp.dao.RoleDAO;
import com.msp.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDAO roleDAO;

    @Override
    public void addRole(Role role) {
        roleDAO.addRole(role);
    }

    @Override
    public Role getRoleByRoleName(String roleName) {
        return roleDAO.getRoleByRoleName(roleName);
    }

    @Override
    public Role getRoleById(int id) {
        return roleDAO.getRoleById(id);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDAO.getAllRoles();
    }

    @Override
    public void updateRoles(Role role) {
        roleDAO.updateRoles(role);
    }

    @Override
    public void deleteRoleById(int id) {
        roleDAO.deleteRoleById(id);
    }
}

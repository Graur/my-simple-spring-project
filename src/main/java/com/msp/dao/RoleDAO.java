package com.msp.dao;

import com.msp.model.Role;

import java.util.List;

public interface RoleDAO {
    Role getRoleByRoleName(String roleName);

    void addRole(Role role);

    Role getRoleById(int id) ;

    List<Role> getAllRoles() ;

    void updateRoles(Role role);;


    void deleteRoleById(int id);

}

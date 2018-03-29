package com.msp.dbService;

import com.msp.model.Role;

import java.util.List;

public interface RoleService {
    void addRole(Role role);

    Role getRoleByRoleName(String roleName);

    Role getRoleById(int id);

    List<Role> getAllRoles();

    void updateRoles(Role role);

    void deleteRoleById(int id);
}

package com.msp.config.app.origindata;

import com.msp.dbService.RoleService;
import com.msp.dbService.UserService;
import com.msp.model.Role;
import com.msp.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;


public class OriginDataInitializer {

//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private RoleService roleService;
//
//
//    private void init() throws Exception {
//
//        Role roleAdmin = new Role();
//        roleAdmin.setName("ADMIN");
//        roleService.addRole(roleAdmin);
//
//        Role roleUser = new Role();
//        roleUser.setName("USER");
//        roleService.addRole(roleUser);
//
//        User admin = new User();
//        admin.setLogin("admin");
//        admin.setPassword("admin");
//        Set<Role> adminRoles = new HashSet<>();
//        adminRoles.add(roleAdmin);
//        adminRoles.add(roleUser);
//        admin.setRoles(adminRoles);
//
//        userService.insertUser(admin);
//
//        User user = new User();
//        user.setLogin("user");
//        user.setPassword("user");
//        Set<Role> userRoles = new HashSet<>();
//        userRoles.add(roleUser);
//        user.setRoles(userRoles);
//
//        userService.insertUser(user);
//
//    }
}

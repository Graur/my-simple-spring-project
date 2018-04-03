package com.msp.controller;

import com.msp.dbService.RoleService;
import com.msp.dbService.UserService;
import com.msp.model.Role;
import com.msp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Controller
public class UsersController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @RequestMapping(value = { "/" }, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        return "index";
    }

    //URL ="user", write the message
    @RequestMapping(value = { "/user"}, method = RequestMethod.GET)
    public String userPage(ModelMap model, Principal principal) {
        String userName = principal.getName();
        model.addAttribute("message", "Hello, " + userName + "!");
        return "user";
    }

    //URL ="admin", list all users
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView userForm() {
        ModelAndView mav = new ModelAndView("users_list");
        List<User> listUsers = userService.getAllUsers();
        mav.addObject("listUsers", listUsers);
        System.out.println("Controller's userForm method");
        return mav;
    }

    //URL ="insert", add user
   @RequestMapping(value = "/admin/insert", method = RequestMethod.GET)
    public ModelAndView insertUserFormFromGetMethod() {
        ModelAndView mav = new ModelAndView("user_form");
        System.out.println("Controller's insertUserFormFromGetMethod method");
        return mav;
    }

    @RequestMapping(value = "/admin/insert", method = RequestMethod.POST)
    public ModelAndView insertUserFormFromPostMethod(@ModelAttribute User user, @RequestParam("role") String role) {
        Role newRole = new Role();
        newRole.setName(role);
        roleService.addRole(newRole);
        System.out.println("Role: " + role);
        Set<Role> roles = new HashSet<>();

        if(role.equals("ADMIN")){
            Role adminRole = new Role();
            adminRole.setName("USER");
            roles.add(adminRole);
            roleService.addRole(adminRole);
        }
        roles.add(newRole);
        user.setRoles(roles);
        userService.insertUser(user);
        System.out.println("Controller's insertUserFormFromPostMethod method");
        System.out.println("User role: " + user.getRoles() + " AND user info is: " + user.toString());
        return new ModelAndView("redirect:/admin");
    }

    //URL ="/delete", delete user
    @RequestMapping(value = {"/admin/delete"}, method = RequestMethod.GET)
    public ModelAndView deleteUserForm(@RequestParam("id") int id) {
        User user = userService.getUser(id);
        Set<Role> roles = user.getRoles();
        Role isItAdminRole = new Role();
        isItAdminRole.setName("ADMIN");
        if(roles.contains(isItAdminRole)){
            roleService.deleteRoleById(id + 1);
        }
        userService.deleteUser(id);
        roleService.deleteRoleById(id);
        System.out.println("Controller's deleteUserForm method");
        return new ModelAndView("redirect:/admin");
    }

    //URL ="update", update user
    @RequestMapping(value = "/admin/update", method = RequestMethod.GET)
    public ModelAndView updateUserFormGetMethod(@ModelAttribute User user) {
        ModelAndView mav = new ModelAndView("user_form");
        int updateUserId = user.getId();
        User existingUser = userService.getUser(updateUserId);
        mav.addObject("user", existingUser);
        System.out.println("Controller's updateUserFormGetMethod method");
        System.out.println("USER INFO " + existingUser.toString());
        return mav;
    }

    @RequestMapping(value = "/admin/update", method = RequestMethod.POST)
    public ModelAndView updateUserFormPostMethod(@ModelAttribute User user, @RequestParam("role") String role) {
        Role newRole = roleService.getRoleById(user.getId());
        Set<Role> roles = new HashSet<>();
        Role oldRole = roleService.getRoleById(user.getId());
        roles.add(oldRole);
        newRole.setName(role);

        if(role.equals("USER") && (role.equals(oldRole.getName()))) {
            System.out.println("Set of the roles is " + roles);
            System.out.println("after role service update " + newRole + " " + newRole.getId());
        } else if (role.equals("ADMIN") && (role.equals(oldRole.getName()))){
            Role userRole = roleService.getRoleById(user.getId()+ 1);
            roles.add(userRole);
        } else if (role.equals("ADMIN") && !(role.equals(oldRole.getName()))){
            roles.remove(oldRole);
            roles.add(newRole);
            roleService.updateRoles(newRole);
            Role userRole = new Role();
            userRole.setName("USER");
            roles.add(userRole);
            roleService.addRole(userRole);
        } else if (role.equals("USER") && !(role.equals(oldRole.getName()))){
            roles.remove(oldRole);
            roles.add(newRole);
            roleService.updateRoles(newRole);
            roleService.deleteRoleById(user.getId()+ 1);
        }

        user.setRoles(roles);
        userService.updateUser(user);
        System.out.println("NEW user info is " + user.toString());
        System.out.println("Controller's updateUserFormPostMethod method");
        return new ModelAndView("redirect:/admin");
    }

    //URL ="logout", write the message
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutUser(){

        System.out.println("Controller's logoutUser method");
        return "index";
    }
}

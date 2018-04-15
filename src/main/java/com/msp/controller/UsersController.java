package com.msp.controller;

import com.msp.dbService.RoleService;
import com.msp.dbService.UserService;
import com.msp.model.Role;
import com.msp.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.security.Principal;
import java.util.List;
import java.util.Set;


@Controller
public class UsersController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    private static final Logger logger = LoggerFactory.getLogger(UsersController.class);

    @RequestMapping(value = { "/" }, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        logger.info("index page");
        return "index";
    }

    //URL ="user", write the message
    @RequestMapping(value = { "/user"}, method = RequestMethod.GET)
    public String userPage(ModelMap model, Principal principal) {
        String userName = principal.getName();
        model.addAttribute("message", "Hello, " + userName + "!");
        logger.info("user page");
        return "user";
    }

    //URL ="admin", list all users
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView adminPage() {
        ModelAndView mav = new ModelAndView("users_list");
        List<User> listUsers = userService.getAllUsers();
        mav.addObject("listUsers", listUsers);
        logger.info("admin page");
        return mav;
    }

    //URL ="insert", add user
   @RequestMapping(value = "/admin/insert", method = RequestMethod.GET)
    public ModelAndView insertUserForm() {
        ModelAndView mav = new ModelAndView("user_form");
       logger.info("add user form");
        return mav;
    }

    @RequestMapping(value = "/admin/insert", method = RequestMethod.POST)
    public ModelAndView insertUser(@ModelAttribute User user, @RequestParam("role") String role) {
        Set<Role> roles = roleService.getSetOfRoles(role);
        user.setRoles(roles);
        roleService.updateSetOfRoles(roles);
        userService.insertUser(user);
        logger.info("----- ADD USER: User role: " + user.getRoles() + ". And user info is: " + user.toString());
        return new ModelAndView("redirect:/admin");
    }

    //URL ="/delete", delete user
    @RequestMapping(value = {"/admin/delete"}, method = RequestMethod.GET)
    public ModelAndView deleteUser(@RequestParam("id") int id) {
        userService.deleteUser(id);
        logger.info("----- DELETE USER: user with id: " + id + " - was deleted");
        return new ModelAndView("redirect:/admin");
    }

    //URL ="update", update user
    @RequestMapping(value = "/admin/update", method = RequestMethod.GET)
    public ModelAndView updateUserForm(@ModelAttribute User user) {
        ModelAndView mav = new ModelAndView("user_form");
        int updateUserId = user.getId();
        User existingUser = userService.getUser(updateUserId);
        mav.addObject("user", existingUser);
        logger.info("----- UPDATE USER FORM ----- OLD user info is: " + existingUser.toString());
        return mav;
    }

    @RequestMapping(value = "/admin/update", method = RequestMethod.POST)
    public ModelAndView updateUser(@RequestParam("id") int id,
                                   @RequestParam("name") String name,
                                   @RequestParam("login") String login,
                                   @RequestParam("password") String password,
                                   @RequestParam("role") String role) {
        User updatedUser = userService.getUser(id);
        Set<Role> roles = roleService.getSetOfRoles(role);

        updatedUser.setName(name);
        updatedUser.setLogin(login);
        updatedUser.setPassword(password);
        updatedUser.setRoles(roles);

        roleService.updateSetOfRoles(roles);
        userService.updateUser(updatedUser);

        logger.info("----- UPDATED USER: NEW user info is: " + updatedUser.toString() + ". With gifted roles: " + roles);
        return new ModelAndView("redirect:/admin");
    }

    //URL ="logout", write the message
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutUser(){

        logger.info("+++ LOGOUT +++");
        return "index";
    }
    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
    public String accessDenied(ModelMap model, Principal principal){
        String userName = principal.getName();
        model.addAttribute("name", userName);
        logger.warn("!!! WARNING !!! USER " + userName + " TRY TO GET ACCESS TO ADMINs PAGES");
        return "accessDenied";
    }
}

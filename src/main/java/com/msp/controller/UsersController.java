package com.msp.controller;

import com.msp.dbService.DBService;
import com.msp.model.User;
import com.msp.servlets.LoginServlet;
import com.msp.servlets.LogoutServlet;
import com.msp.servlets.UserWriterServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static com.msp.servlets.LogoutServlet.deleteCookies;

@Controller
public class UsersController {

    @Autowired
    DBService dbService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String startUp(){
        System.out.println("redirect:/login");
        return "WEB-INF/views/index";
    }

    //URL ="admin", list all users
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView userForm() {
        ModelAndView mav = new ModelAndView("WEB-INF/views/UsersList");
        List<User> listUsers = dbService.getAllUsers();
        mav.addObject("listUsers", listUsers);
        System.out.println("Controller's userForm method");
        return mav;
    }

    //URL ="insert", add user
    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public ModelAndView insertUserFormFromGetMethod() {
        ModelAndView mav = new ModelAndView("WEB-INF/views/UserForm");
        System.out.println("Controller's insertUserFormFromGetMethod method");
        return mav;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ModelAndView insertUserFormFromPostMethod(@ModelAttribute User user) {
        dbService.insertUser(user);
        System.out.println("Controller's insertUserFormFromPostMethod method");
        return new ModelAndView("redirect:/admin");
    }

    //URL ="/delete", delete user
    @RequestMapping(value = {"/delete"}, method = RequestMethod.GET)
    public ModelAndView deleteUserForm(@RequestParam("id") int id) {
        dbService.deleteUser(id);
        System.out.println("Controller's deleteUserForm method");
        return new ModelAndView("redirect:/admin");
    }

    //URL ="update", update user
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView updateUserFormGetMethod(@ModelAttribute User user) {
        ModelAndView mav = new ModelAndView("WEB-INF/views/UserForm");
        int updateUserId = user.getId();
        User existingUser = dbService.getUser(updateUserId);
        mav.addObject("user", existingUser);
        System.out.println("Controller's updateUserFormGetMethod method");
        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView updateUserFormPostMethod(@ModelAttribute User user) {
        dbService.updateUser(user);
        System.out.println("Controller's updateUserFormPostMethod method");
        return new ModelAndView("redirect:/admin");
    }

    //URL ="user", write the message
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public void printMessageToUser(HttpServletRequest req, HttpServletResponse resp){
        String login = null;

        Cookie[] cookies = req.getCookies();
        for(Cookie cookie : cookies) {
            if (cookie.getName().equals("admin")) {
                login = cookie.getValue();
            } else {
                login = cookie.getValue();
            }
        }
        System.out.println("Controller's printMessageToUser method");
        UserWriterServlet.printToBrowser(req,resp,login);
    }

    //URL ="login", write the message
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginUser(HttpServletRequest req, HttpServletResponse resp){
        String login = req.getParameter("login");
        String pass = req.getParameter("password");
        Cookie[] cookies = req.getCookies();
        Cookie cookie;
        List<User> usersList = dbService.getAllUsers();
        String result = null;

        if(LoginServlet.userIsExist(login, pass, usersList)){
            String userRole = LoginServlet.getRoleByLoginAndPass(login, pass);
            deleteCookies(cookies, resp);
            cookie = new Cookie(userRole, login);
            System.out.println("user ROLE: " + userRole);
            resp.addCookie(cookie);
            if (userRole.equals("admin")) {
                result = "redirect:/admin";
            } else if (userRole.equals("USER")){
                result = "redirect:/user";
            }
        } else {
            result = "redirect:/";
        }
        System.out.println(result);
        return result;
    }

    //URL ="logout", write the message
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutUser(HttpServletRequest req, HttpServletResponse resp){
        Cookie[] cookies = req.getCookies();
        deleteCookies(cookies, resp);
        System.out.println("Controller's logoutUser method");
        return "WEB-INF/views/logoutprocess";
    }

    @PostConstruct
    public void init(){
        User admin = new User(1,"admin", "admin", "admin", "admin");
        User user = new User(1,"user", "user", "user", "USER");
        dbService.insertUser(admin);
        dbService.insertUser(user);
        System.out.println("user1 added from postconstruct method");
    }
}

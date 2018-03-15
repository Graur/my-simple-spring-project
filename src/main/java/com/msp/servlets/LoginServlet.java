package com.msp.servlets;

import com.msp.dao.UsersDAO;
import com.msp.dao.UsersDaoFactory;
import com.msp.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//@WebServlet("/login")
public class LoginServlet extends HttpServlet {
//    private UsersDAO usersDAO = UsersDaoFactory.getUsersDAO();
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String login = req.getParameter("login");
//        String pass = req.getParameter("password");
//        Cookie[] cookies = req.getCookies();
//        Cookie cookie;
//
//        if(userIsExist(login, pass)){
//            User.ROLE userRole = getRoleByLoginAndPass(login, pass);
//            LogoutServlet.deleteCookies(cookies, resp);
//            cookie = new Cookie(userRole.toString(), login);
//            System.out.println("user ROLE: " + userRole.toString());
//            resp.addCookie(cookie);
//            if ((userRole.toString()).equals(User.ROLE.ADMIN.toString())) {
//                resp.sendRedirect("/admin");
//            } else if ((userRole.toString()).equals(User.ROLE.USER.toString())){
//                resp.sendRedirect("/user");
//            }
//        } else {
//            resp.sendRedirect("/index.jsp");
//        }
//    }
//
    public static boolean userIsExist (String login, String password, List<User> userList){
        boolean result = false;

        for (User user : userList){
            if((user.getLogin().equals(login)) && (user.getPassword().equals(password))){
                result = true;
                break;
            }
        }

        return  result;
    }

    public static User.ROLE getRoleByLoginAndPass(String login, String password){
        User.ROLE result;

        if((login.equals("admin")) && (password.equals("admin"))){
            result = User.ROLE.ADMIN;

        } else {
            result = User.ROLE.USER;
        }

        return result;
    }
}

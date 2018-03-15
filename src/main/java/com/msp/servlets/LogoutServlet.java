package com.msp.servlets;

import com.msp.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Cookie[] cookies = req.getCookies();
//        deleteCookies(cookies, resp);
//        resp.sendRedirect("/logoutprocess.jsp");
//    }
//
    public static void deleteCookies(Cookie[] cookies, HttpServletResponse resp){
        for (Cookie delCookie : cookies){
            if (delCookie.getName().equals(User.ROLE.USER.toString()) || delCookie.getName().equals(User.ROLE.ADMIN.toString())) {
                delCookie.setValue("");
                delCookie.setPath("/");
                delCookie.setMaxAge(0);
                resp.addCookie(delCookie);
            }
        }
    }
}

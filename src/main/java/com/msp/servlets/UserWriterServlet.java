package com.msp.servlets;

import com.msp.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

//@WebServlet("/user")
public class UserWriterServlet extends HttpServlet {

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String login = null;
//
//        Cookie[] cookies = req.getCookies();
//        for(Cookie cookie : cookies) {
//            if (cookie.getName().equals(User.ROLE.ADMIN.toString())) {
//                login = cookie.getValue();
//            } else {
//                login = cookie.getValue();
//            }
//        }
//        UserWriterServlet.printToBrowser(req,resp,login);
//    }
//
    public static void printToBrowser(HttpServletRequest req, HttpServletResponse resp, String login){
        try {
            Writer out = resp.getWriter();
            out.write("Hello, " + login);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

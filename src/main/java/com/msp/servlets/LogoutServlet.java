package com.msp.servlets;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
//
//    }
//
    public static void deleteCookies(Cookie[] cookies, HttpServletResponse resp){
        for (Cookie delCookie : cookies){
            if (delCookie.getName().equals("USER") || delCookie.getName().equals("admin")) {
                delCookie.setValue("");
                delCookie.setPath("/");
                delCookie.setMaxAge(0);
                resp.addCookie(delCookie);
            }
        }
    }
}

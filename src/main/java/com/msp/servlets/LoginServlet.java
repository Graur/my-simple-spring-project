package com.msp.servlets;


import com.msp.model.User;

import java.util.List;

//@WebServlet("/login")
public class LoginServlet {
//
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

    public static String getRoleByLoginAndPass(String login, String password){
        String result;

        if((login.equals("admin")) && (password.equals("admin"))){
            result = "admin";

        } else {
            result = "USER";
        }

        return result;
    }
}

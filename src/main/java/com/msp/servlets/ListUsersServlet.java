package com.msp.servlets;

import com.msp.dao.UsersDAO;
import com.msp.dao.UsersDaoFactory;
import com.msp.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//@WebServlet ("/admin")
public class ListUsersServlet extends HttpServlet {
//    private UsersDAO usersDAO = UsersDaoFactory.getUsersDAO();
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //for testing
//        String uri = req.getRequestURI();
//        System.out.println("Requested Resource from GET method of ListUsersServlet::" + uri);
//
//        //list of users
//        List<User> userList = usersDAO.getAllUsers();
//        req.setAttribute("listUsers", userList);
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("UsersList.jsp");
//        requestDispatcher.forward(req, resp);
//    }
}

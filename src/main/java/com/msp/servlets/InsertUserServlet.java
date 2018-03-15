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
import java.sql.SQLException;

//@WebServlet("/insert")
public class InsertUserServlet extends HttpServlet {
//    private UsersDAO usersDAO = UsersDaoFactory.getUsersDAO();
//
//    public InsertUserServlet() throws SQLException {
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//            String name = req.getParameter("name");
//            String login = req.getParameter("login");
//            String password = req.getParameter("password");
//            User newUser = new User(name, login, password);
//            usersDAO.insertUser(newUser);
//            resp.sendRedirect("admin");
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("UserForm.jsp");
//        requestDispatcher.forward(req, resp);
//    }
}

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

//@WebServlet("/update")
public class UpdateUserServlet extends HttpServlet {
//    private UsersDAO usersDAO = UsersDaoFactory.getUsersDAO();
//
//    public UpdateUserServlet() {
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//            int id = Integer.parseInt(req.getParameter("id"));
//            String name = req.getParameter("name");
//            String login = req.getParameter("login");
//            String password = req.getParameter("password");
//            User updatedUser = new User(id, name, login, password);
//            usersDAO.updateUser(updatedUser);
//            resp.sendRedirect("admin");
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//            int id = Integer.parseInt(req.getParameter("id"));
//            User existingUser = usersDAO.getUser(id);
//            RequestDispatcher requestDispatcher = req.getRequestDispatcher("UserForm.jsp");
//            req.setAttribute("user", existingUser);
//            requestDispatcher.forward(req, resp);
//
//        }
}

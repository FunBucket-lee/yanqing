package com.qing.servlet;

import com.qing.entity.User;
import com.qing.service.UserService;
import com.qing.service.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddUserServlet", value = "/AddUserServlet")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if ((username != null || !username.equals("")) && (password != null || !password.equals(""))) {
            User user = new User(username, password);
            UserService userService = new UserServiceImpl();
            userService.addUser(user);
        }
        response.sendRedirect("pageMobile");
    }
}

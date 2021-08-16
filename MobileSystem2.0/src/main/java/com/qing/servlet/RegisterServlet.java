package com.qing.servlet;

import com.qing.entity.User;
import com.qing.service.UserService;
import com.qing.service.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();

        String username = request.getParameter("username");
        UserService userService = new UserServiceImpl();
        User user = userService.findByName(username);
        String str = "";
        if (user == null) {
            str = "<span id='warn' style='color:green'>用户名可以使用</span>";
        } else {
            str = "<span id='warn' style='color:red'>用户名已被使用</span>";
        }
        System.out.println(str);
        writer.print(str);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

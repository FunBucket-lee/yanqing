package com.qing.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletHome", value = "/home")
public class ServletHome extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = (String) request.getSession().getAttribute("username");
        if (username == null) {
            request.setAttribute("error", "非法访问，请先登录");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }
        PrintWriter writer = response.getWriter();

        writer.print("<h1>登陆成功！这是Home首页!!</h1>");
        writer.print("欢迎" + username + "用户");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}

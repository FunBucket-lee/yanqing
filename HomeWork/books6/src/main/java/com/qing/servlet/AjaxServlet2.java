package com.qing.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AjaxServlet2", value = "/JsonAjax")
public class AjaxServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        String username = request.getParameter("username");
        String jsonStr;
        if (username.equals("admin")) {
            jsonStr = "{\"flag\":true,\"msg\":\"<span style='color: red'>用户名已被使用！</span>\"}";
        } else {
            jsonStr = "{\"flag\":false,\"msg\":\"<span style='color: green'>用户名可以使用！</span>\"}";
        }
        System.out.println(jsonStr);
        writer.print(jsonStr);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

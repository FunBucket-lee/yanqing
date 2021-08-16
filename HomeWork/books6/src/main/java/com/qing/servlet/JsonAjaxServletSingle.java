package com.qing.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qing.entity.Person;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "JsonAjaxServlet", value = "/jsonAjaxServletSingle")
public class JsonAjaxServletSingle extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        Person zhang = new Person("张无忌", 29, true);
        ObjectMapper mapper = new ObjectMapper();
        String string = mapper.writeValueAsString(zhang);
        System.out.println(string);
        writer.print(string);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

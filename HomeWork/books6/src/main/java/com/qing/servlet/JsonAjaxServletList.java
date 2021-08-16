package com.qing.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qing.entity.Person;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "JsonAjaxServletList", value = "/jsonAjaxServletList")
public class JsonAjaxServletList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        Person person1 = new Person("张无忌", 18, true);
        Person person2 = new Person("李清照", 19, false);
        Person person3 = new Person("李寻欢", 20, true);

        ArrayList<Person> list = new ArrayList<>();
        list.add(person1);
        list.add(person2);
        list.add(person3);

        ObjectMapper mapper = new ObjectMapper();
        String string = mapper.writeValueAsString(list);
        System.out.println(string);
        writer.println(string);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

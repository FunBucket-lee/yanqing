package com.qing.servlet;

import com.qing.entity.City;
import com.qing.entity.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletStudent", value = "/ServletStudent")
public class ServletStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("username", "zhangsan");
        HttpSession session = request.getSession();
        session.setAttribute("password","123456");
        Student student = new Student();
        student.setName("李白");
        City city = new City();
        city.setAddress("广州");
        request.setAttribute("student", student);
        request.getRequestDispatcher("demo10.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

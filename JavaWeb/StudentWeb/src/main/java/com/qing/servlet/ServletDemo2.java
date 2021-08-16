package com.qing.servlet;

import com.qing.pojo.Student;
import com.qing.test.Test1;

import javax.servlet.*;
import java.io.IOException;

public class ServletDemo2 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html;charset=GBK");
        Student student = Test1.findAllById();
        servletResponse.getWriter().write("<h1>"+student.getStudentname()+"</h1>");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}

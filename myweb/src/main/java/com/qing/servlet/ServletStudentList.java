package com.qing.servlet;

import com.qing.dao.BookDao;
import com.qing.entity.Book;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ServletStudentList", value = "/students")
public class ServletStudentList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<String> student = new ArrayList<>();
        student.add("张无忌");
        student.add("李寻欢");
        student.add("黄飞鸿");
        student.add("方世玉");
        student.add("霍元甲");
        request.setAttribute("student", student);


        Map studentMap = new HashMap<>();
        studentMap.put("a001", "张无忌");
        studentMap.put("a002", "李寻欢");
        studentMap.put("a003", "黄飞鸿");
        studentMap.put("a004", "方世玉");
        studentMap.put("a005", "霍元甲");
        request.setAttribute("studentMap", studentMap);
//        request.getRequestDispatcher("demo11.jsp").forward(request, response);

        List<Book> books = BookDao.bookList();
        request.setAttribute("books", books);
        request.getRequestDispatcher("jstl2.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

package com.qing.servlet;

import com.qing.entity.Book;
import com.qing.service.BookServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "BookDetailServlet", value = "/bookDetail")
public class BookDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        BookServiceImpl bookService = new BookServiceImpl();
        Book book = bookService.findBookById(id);
        request.setAttribute("book",book);
        request.getRequestDispatcher("bookDetail.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

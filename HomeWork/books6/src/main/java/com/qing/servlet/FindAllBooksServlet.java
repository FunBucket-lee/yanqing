package com.qing.servlet;

import com.qing.entity.Book;
import com.qing.service.BookServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FindAllBooksServlet", value = "/findAllBooks")
public class FindAllBooksServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        BookServiceImpl bookService = new BookServiceImpl();

        List<Book> books = bookService.findAllBooks();

        request.setAttribute("books", books);
        request.getRequestDispatcher("pageBooks").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

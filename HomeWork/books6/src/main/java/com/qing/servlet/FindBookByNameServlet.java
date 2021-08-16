package com.qing.servlet;

import com.qing.entity.Book;
import com.qing.service.BookService;
import com.qing.service.BookServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FindBookByNameServlet", value = "/searchBooks")
public class FindBookByNameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        BookService bookService = new BookServiceImpl();
        List<Book> books = bookService.findBookByName(name);
        request.setAttribute("books", books);
        request.getRequestDispatcher("booklist.jsp").forward(request, response);
    }
}

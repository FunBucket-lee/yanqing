package com.qing.servlet;

import com.qing.entity.Book;
import com.qing.service.BookService;
import com.qing.service.BookServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "ToUpdateServlet", value = "/toUpdate")
public class ToUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        BookService bookService = new BookServiceImpl();
        Book book = bookService.findBookById(id);
        request.setAttribute("book", book);
        request.getRequestDispatcher("updateBook.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        BookService bookService = new BookServiceImpl();
        Book book = new Book();
        try {
            BeanUtils.populate(book, request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        bookService.updateBook(book);
        response.sendRedirect("findAllBooks");
    }
}

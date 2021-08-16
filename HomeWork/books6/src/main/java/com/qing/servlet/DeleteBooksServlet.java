package com.qing.servlet;

import com.qing.service.BookService;
import com.qing.service.BookServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteBooksServlet", value = "/deleteBooks")
public class DeleteBooksServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] idss = request.getParameterValues("id");
        int[] ids = new int[idss.length];
        for (int i = 0; i < idss.length; i++) {
            ids[i] = Integer.parseInt(idss[i]);
        }
        BookService bookService = new BookServiceImpl();
        bookService.delBooks(ids);
        response.sendRedirect("findAllBooks");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

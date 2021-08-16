package com.qing.servlet;

import com.github.pagehelper.PageInfo;
import com.qing.entity.Book;
import com.qing.service.BookService;
import com.qing.service.BookServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PageBookServlet", value = "/pageBooks")
public class PageBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNum = 1;
        String pno = request.getParameter("pageNum");
        if (pno != null && !pno.equals("")) {
            pageNum= Integer.parseInt(pno);
        }
        int pageSize = 3;
        BookService bookService = new BookServiceImpl();
        PageInfo<Book> pageInfo = bookService.findAllBooksPage(pageNum,pageSize);
        request.setAttribute("pageInfo",pageInfo);
        request.getRequestDispatcher("booklist.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

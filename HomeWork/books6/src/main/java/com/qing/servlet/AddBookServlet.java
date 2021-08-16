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

@WebServlet(name = "AddBookServlet", value = "/addBook")
public class AddBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
/*        String name = request.getParameter("name");
        int pnum = Integer.parseInt(request.getParameter("pnum"));
        double price = Double.parseDouble(request.getParameter("price"));
        String category = request.getParameter("category");
        String imgurl = request.getParameter("imgurl");
        String description = request.getParameter("description");
        String author = request.getParameter("author");
        int sales = Integer.parseInt(request.getParameter("sales"));*/

        Book book = new Book();
        try {
            BeanUtils.populate(book,request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        BookService bookService = new BookServiceImpl();
        bookService.addBook(book);
        response.sendRedirect("findAllBooks");
    }
}

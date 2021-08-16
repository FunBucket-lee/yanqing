package com.qing.servlet;

import com.qing.entity.Book;
import com.qing.service.BookService;
import com.qing.service.BookServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "SearchBookServlet", value = "/searchBook")
public class SearchBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String category = request.getParameter("category");
        String author = request.getParameter("author");
        String nPrice = request.getParameter("minPrice");
        String xPrice = request.getParameter("maxPrice");
        Double minPrice;
        if (nPrice.equals("")) {
            minPrice = null;
        } else {
            minPrice = Double.parseDouble(nPrice);
        }
        Double maxPrice;
        if (xPrice.equals("")) {
            maxPrice = null;
        } else {
            maxPrice = Double.parseDouble(xPrice);
        }
        HashMap map = new HashMap<>();
        map.put("name", name);
        map.put("category", category);
        map.put("author", author);
        map.put("minPrice", minPrice);
        map.put("maxPrice", maxPrice);

        BookService bookService = new BookServiceImpl();
        List<Book> books = bookService.searchBook(map);
        request.setAttribute("books",books);
        request.getRequestDispatcher("booklist.jsp").forward(request,response);
    }
}

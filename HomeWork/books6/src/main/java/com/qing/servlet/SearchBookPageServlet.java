package com.qing.servlet;

import com.github.pagehelper.PageInfo;
import com.qing.entity.Book;
import com.qing.service.BookService;
import com.qing.service.BookServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "SearchBookPageServlet", value = "/searchBookPage")
public class SearchBookPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        int pageNum = 1;
        String pno = request.getParameter("pageNum");
        if (pno != null && !pno.equals("")) {
            pageNum = Integer.parseInt(pno);
        }
        int pageSize = 3;

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

        PageInfo<Book> pageInfo = bookService.searchBookPage(pageNum, pageSize, map);
        request.setAttribute("pageInfo", pageInfo);
        request.setAttribute("name", name);
        request.setAttribute("category", category);
        request.setAttribute("author", author);
        request.setAttribute("minPrice", minPrice);
        request.setAttribute("maxPrice", maxPrice);
        request.getRequestDispatcher("SearchPageBooklist.jsp").forward(request, response);
    }
}

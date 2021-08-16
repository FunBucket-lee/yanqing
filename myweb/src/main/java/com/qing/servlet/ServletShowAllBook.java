package com.qing.servlet;

import com.qing.dao.BookDao;
import com.qing.entity.Book;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "ServletShowAllBook", value = "/allBook")
public class ServletShowAllBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        response.setContentType("text/html;charset=utf-8");
        Map<String, Book> allBooks = BookDao.findAllBooks();
        writer.print("本站有一下好书，点击添加购物车购买");

        writer.print("<table border='1'>");
        for (String id : allBooks.keySet()) {
            writer.print("<tr><td>" + allBooks.get(id).getId() + "</td><td>"
                    + allBooks.get(id).getName() + "</td><td>"
                    + allBooks.get(id).getPrice() + "</td><td>"
                    + allBooks.get(id).getAuthor() + "</td<td><a href='addCart?id="
                    + id + "' target='_blank'>加入购物车</a></td></tr>"
            );
        }
        writer.print("</table>");
        writer.print("<a href='showCart'>查看购物车</a>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}

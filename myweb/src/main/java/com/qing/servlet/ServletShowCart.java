package com.qing.servlet;

import com.qing.dao.BookDao;
import com.qing.entity.Book;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "ServletShowCart", value = "/showCart")
public class ServletShowCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print("购物车有以下商品</br>");
        HttpSession session = request.getSession();
        Map<String, Integer> cart = (Map<String, Integer>) session.getAttribute("cart");
        if (cart == null) {
            writer.print("你还什么都没买呢");
            response.setHeader("refresh", "2;url=" + request.getContextPath() + "/allBook");
            return;
        } else {
            for (String id : cart.keySet()) {
                Book book = BookDao.findBookById(id);
                writer.print(book.getName() + " " + cart.get(id) + "本</br>");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

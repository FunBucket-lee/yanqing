package com.qing.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ServletAddCart", value = "/addCart")
public class ServletAddCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        String id = request.getParameter("id");
        HttpSession session = request.getSession();
        Map<String, Integer> cart = (Map<String, Integer>) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<String, Integer>();
        }
        if (cart.keySet().contains(id)) {
            Integer count = cart.get(id);
            cart.put(id, count+1);
        } else {
            cart.put(id, 1);
        }
        session.setAttribute("cart", cart);
        writer.print("<script>alert('购买成功');this.close()</script>");
        writer.print("购买成功<a href='allBook'>返回购物</a>");
        writer.print("<a href='showCart'>查看购物车</a>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

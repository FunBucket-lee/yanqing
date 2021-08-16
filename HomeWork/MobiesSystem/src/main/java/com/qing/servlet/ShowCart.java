package com.qing.servlet;

import com.qing.dao.MobiesDao;
import com.qing.entity.Mobile;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ShowCart", value = "/showCart")
public class ShowCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();
        Map<Integer, Integer> cart = (Map<Integer, Integer>) session.getAttribute("cart");
        request.setAttribute("cart", cart);
        request.getRequestDispatcher("Cart.jsp").forward(request, response);
        //        if (cart == null) {
//            writer.print("<h2>你还什么都没买呢</h2>");
//            response.setHeader("refresh", "2;url=" + request.getContextPath() + "/mobiles");
//            return;
//        } else {
//            writer.print("<h2>购物车有以下商品</h2>");
//            for (Integer id : cart.keySet()) {
//                Mobile mobile = MobiesDao.findByid(id);
//                System.out.println("=======================" + mobile.toString());
//                writer.print(mobile.getBrand() + " " + mobile.getType() + "  " + cart.get(id) + "台</br>");
//            }
//            writer.print("<a style='text-decoration: none;color: cornflowerblue' href='mobiles'>返回购物</a>");
//        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

package com.qing.servlet;

import com.qing.dao.MobiesDao;
import com.qing.entity.Mobile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        int id = Integer.parseInt(request.getParameter("id"));
        Mobile mobile = MobiesDao.findByid(id);

        HttpSession session = request.getSession();
        Map<Mobile, Integer> cart = (Map<Mobile, Integer>) session.getAttribute("cart");

        if (cart == null) {
            cart = new HashMap<Mobile, Integer>();
        }

        if (cart.keySet().contains(mobile)) {
            Integer count = cart.get(mobile);
            cart.put(mobile, count + 1);
        } else {
            cart.put(mobile, 1);
        }

        session.setAttribute("cart", cart);
        writer.print("<script>alert('购买成功');this.close();</script>");
        writer.print("购买成功&nbsp;&nbsp;<a  style='text-decoration: none;color: cornflowerblue' href='MobileShop'>返回购物</a>");
        writer.print("&nbsp;&nbsp;<a  style='text-decoration: none;color: cornflowerblue' href='showCart'>查看购物车</a>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

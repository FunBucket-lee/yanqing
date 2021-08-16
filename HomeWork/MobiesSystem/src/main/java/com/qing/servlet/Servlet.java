package com.qing.servlet;

import com.qing.dao.MobiesDao;
import com.qing.entity.Mobile;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "Servlet", value = "/MobileShop")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List all = MobiesDao.findAll();
        request.setAttribute("all", all);

        //用户Cookie存储浏览记录
        Cookie[] cookies = request.getCookies();
        List<Mobile> history = new ArrayList();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("historyMobileId")) {
                String value = cookie.getValue();
                String[] id = value.split("-");//3-2-4
                for (String s : id) {
                    Mobile mobile = MobiesDao.findByid(Integer.parseInt(s));
                    history.add(mobile);
                }
                request.setAttribute("history",history);
            }
        }
        request.getRequestDispatcher("Mobies.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

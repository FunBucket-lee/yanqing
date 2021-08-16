package com.qing.servlet;

import com.qing.dao.MobiesDao;
import com.qing.entity.Mobile;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;

@WebServlet(name = "MobileDetailServlet", value = "/mobileDetail")
public class MobileDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();*/

        int id = Integer.parseInt(request.getParameter("id"));
        Mobile mobile = MobiesDao.findByid(id);
        request.setAttribute("mobile", mobile);

        //记录浏览手机记录
        String historyMobileId = organizeId(String.valueOf(id), request);
        Cookie cookie = new Cookie("historyMobileId", historyMobileId);
        cookie.setMaxAge(160);
        response.addCookie(cookie);

        request.getRequestDispatcher("detail.jsp").forward(request, response);
    }

    private String organizeId(String id, HttpServletRequest request) {
        // 得到客户端的Cookie
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return id;
        }

        // 查找有没有name叫做historyMobile的cookie
        Cookie historyMobile = null;
        for (int i = 0; i < cookies.length; i++) {
            if ("historyMobileId".equals(cookies[i].getName())) {
                historyMobile = cookies[i];
            }
        }

        // 如果没有historyMobile的cookie，则还返回id
        if (historyMobile == null) {
            return id;
        }

        String value = historyMobile.getValue();// 4-3-2
        String[] values = value.split("-"); //[4 3 2]
        LinkedList<String> list = new LinkedList<String>(Arrays.asList(values));

        if (list.size() < 3) { //
            if (list.contains(id)) {
                list.remove(id);// 如果包含当前id的值，则删除这个id
            }
        } else {
            if (list.contains(id)) {
                list.remove(id); //[4 2]
            } else {// 说明有3个浏览手机的id了
                list.removeLast();// 把最后一个id删除  3 2
            }
        }
        list.addFirst(id);// 最新手机的id添加到最前面  [3 4  2 ]

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                sb.append("-");
            }
            sb.append(list.get(i));
        }

        System.out.println(sb); // 3-4-2

        return sb.toString();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

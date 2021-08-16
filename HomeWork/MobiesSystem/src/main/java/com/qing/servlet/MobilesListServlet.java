package com.qing.servlet;

import com.qing.dao.MobiesDao;
import com.qing.entity.Mobile;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet(name = "MobilesListServlet", value = "/history")
public class MobilesListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();*/

      /*  writer.print("<h1>欢迎" + request.getSession().getAttribute("username") + "登录手机商场</h1>");*/
        List all = MobiesDao.findAll();
    /*    writer.print("<table border='1' style='padding:0'>");
        writer.print("<tr><td>品牌</td><td>型号</td><td>详细信息</td><td>购物车</td></tr>");*/
/*        for (Integer id : all.keySet()) {
            writer.print("<tr><td>"
                    + all.get(id).getBrand() + "</td><td>"
                    + all.get(id).getType() + "</td><td>"
                    + "<a style='text-decoration: none;color: cornflowerblue' href='mobileDetail?id=" + id + "'>详细信息</a></td><td><a style='text-decoration: none;color: cornflowerblue' href='addCart?id="
                    + id + "'>加入购物车</a></td></tr>"
            );
        }*/


/*        writer.print("</table><br />");
        writer.print("<a style='text-decoration: none;color: cornflowerblue' href='showCart'>查看购物车</a>&nbsp;&nbsp;");
        writer.print("<a style='text-decoration: none;color: cornflowerblue' href='login.jsp'>退出登录</a>");

        writer.print("<br /><hr/>最近预览记录:<br />");*/
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("historyMobileId")) {
                String value = cookie.getValue();
                String[] id = value.split("-");
                for (String s : id) {
                    Mobile mobile = MobiesDao.findByid(Integer.parseInt(s));
                  /*  writer.print(mobile.getBrand() + "  " + mobile.getType() + "<br />");*/
                }
            }
        }
    }
}

package com.qing.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletLogin", value = "/login")
public class ServletLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String code = request.getParameter("code");//用户输入验证码
        String remember = request.getParameter("remember");
        String autologin = request.getParameter("autologin");
        String vcode = (String) request.getSession().getAttribute("vcode");//生成的验证码

        if (vcode.equals(code)) {
            if (username.equals("admin") && password.equals("123456")) {
                Cookie ck1 = new Cookie("username", username);
                Cookie ck2 = new Cookie("password", password);
                Cookie ck3 = new Cookie("user", username + "&" + password);
                if (remember != null) {
                    ck1.setMaxAge(600);
                    ck2.setMaxAge(600);
                } else {
                    ck1.setMaxAge(0);
                    ck2.setMaxAge(0);
                }
                if (autologin != null) {
                    ck3.setMaxAge(600);
                } else {
                    ck3.setMaxAge(0);
                }
                response.addCookie(ck1);
                response.addCookie(ck2);
                response.addCookie(ck3);
                request.getSession().setAttribute("username", username);
                request.getRequestDispatcher("home").forward(request, response);
            } else {
                request.setAttribute("error", "用户名或密码错误");
                request.getRequestDispatcher("login.jsp").forward(request, response);

            }
        } else {
            request.setAttribute("error", "验证码错误");
            request.getRequestDispatcher("login.jsp").forward(request, response);

        }
    }
}

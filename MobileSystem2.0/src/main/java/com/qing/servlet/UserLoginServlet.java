package com.qing.servlet;

import com.qing.entity.User;
import com.qing.service.UserService;
import com.qing.service.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserLoginServlet", value = "/userLoginServlet")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String code = request.getParameter("code");//用户输入验证码
        String remember = request.getParameter("remember");
        String autologin = request.getParameter("autologin");
        String vcode = (String) request.getSession().getAttribute("vcode");//生成的验证码
        UserService userService = new UserServiceImpl();
        User user = userService.findByNameAndPwd(username, password);
        if (code.equals(vcode)) {
            if (user != null) {
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
                request.getRequestDispatcher("pageMobile").forward(request, response);
            } else {
                request.setAttribute("error", "用户名或密码错误");
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("error", "验证码错误");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
    }
}

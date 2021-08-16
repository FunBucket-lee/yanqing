package com.qing.servlet;

import com.github.pagehelper.PageInfo;
import com.qing.entity.Mobile;
import com.qing.service.MobileService;
import com.qing.service.MobileServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PageServletServlet", value = "/pageMobile")
public class PageMobileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = (String) request.getSession().getAttribute("username");
        System.out.println(username);
        System.out.println(username == null);
        if (username == null) {
            request.setAttribute("error","非法访问，请先登录");
            request.getRequestDispatcher("Login.jsp").forward(request,response);
            return;
        }

        int pageNum = 1;
        int pageSize = 3;
        String pno = request.getParameter("pageNum");

        if (pno != null && !pno.equals("")) {
            pageNum = Integer.parseInt(pno);
        }

        MobileService mobileService = new MobileServiceImpl();

        PageInfo<Mobile> pageInfo = mobileService.findAllMobilePage(pageNum, pageSize);
        request.setAttribute("pageInfo", pageInfo);
        request.getRequestDispatcher("MobileList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

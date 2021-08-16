package com.qing.servlet;

import com.qing.service.MobileService;
import com.qing.service.MobileServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteMobileServlet", value = "/delMobile")
public class DeleteMobileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        MobileService mobileService = new MobileServiceImpl();
        mobileService.deleteMobile(id);
        request.getRequestDispatcher("pageMobile").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

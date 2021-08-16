package com.qing.servlet;

import com.qing.entity.Mobile;
import com.qing.service.MobileService;
import com.qing.service.MobileServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "FindByIdServlet", value = "/findById")
public class FindByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        MobileService mobileService = new MobileServiceImpl();
        int id = Integer.parseInt(request.getParameter("id"));
        Mobile mobile = mobileService.findById(id);
        request.setAttribute("mobile", mobile);
        request.getRequestDispatcher("MobileDetail.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

package com.qing.servlet;

import com.qing.entity.Mobile;
import com.qing.service.MobileService;
import com.qing.service.MobileServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteCheckServlet", value = "/deleteCheck")
public class DeleteCheckServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String[] idss = request.getParameterValues("id");
    int[] ids = new int[idss.length];
    for (int i = 0; i < idss.length; i++) {
      ids[i] = Integer.parseInt(idss[i]);
    }
    MobileService mobileService = new MobileServiceImpl();
    mobileService.delCheck(ids);
    response.sendRedirect("pageMobile");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}

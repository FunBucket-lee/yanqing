package com.qing.servlet;

import com.github.pagehelper.PageInfo;
import com.qing.entity.Mobile;
import com.qing.service.MobileService;
import com.qing.service.MobileServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "SearchMobileServlet", value = "/searchMobile")
public class SearchMobileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        int pageNum = 1;
        String pno = request.getParameter("pageNum");
        if (pno != null && !pno.equals("")) {
            pageNum = Integer.parseInt(pno);
        }
        int pageSize = 3;

        String brand = request.getParameter("brand");
        String type = request.getParameter("type");
        String min = request.getParameter("minPrice");
        String max = request.getParameter("maxPrice");
        Double minPrice;
        if (min != null && !min.equals("")) {
            minPrice = Double.parseDouble(min);
        } else {
            minPrice = null;
        }
        Double maxPrice;
        if (max != null && !max.equals("")) {
            maxPrice = Double.parseDouble(max);
        } else {
            maxPrice = null;
        }


        HashMap<Object, Object> map = new HashMap<>();
        map.put("brand", brand);
        map.put("type", type);
        map.put("minPrice", minPrice);
        map.put("maxPrice", maxPrice);

        MobileService mobileService = new MobileServiceImpl();

        PageInfo<Mobile> pageInfo = mobileService.searchMobilePage(pageNum, pageSize, map);

        request.setAttribute("pageInfo", pageInfo);
        request.setAttribute("brand", brand);
        request.setAttribute("type", type);
        request.setAttribute("minPrice", minPrice);
        request.setAttribute("maxPrice", maxPrice);

        request.getRequestDispatcher("SearchMobileList.jsp").forward(request, response);
    }
}

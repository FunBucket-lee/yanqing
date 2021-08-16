package com.qing.servlet;

import com.qing.entity.Book;
import com.qing.service.BookService;
import com.qing.service.BookServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "AddCartServlet", value = "/addCart")
public class AddCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("utf-8");
       response.setContentType("text/html;charset=utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        BookService bookService = new BookServiceImpl();
        Book book = bookService.findBookById(id);
        HttpSession session = request.getSession();
        Map<Book, Integer> cart = (Map<Book, Integer>) session.getAttribute("cart");

        if (cart == null) {
            cart = new HashMap<Book, Integer>();
        }
        if (cart.containsKey(book)) {
            int count = cart.get(book);
            cart.put(book, count + 1);
        } else {
            cart.put(book, 1);
        }

        session.setAttribute("cart", cart);
        response.getWriter().print("<script>alert('添加购物车成功！');location.href='findAllBooks'</script>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

package com.yutao.shi.web;

import com.google.gson.Gson;
import com.yutao.shi.pojo.Book;
import com.yutao.shi.pojo.Cart;
import com.yutao.shi.pojo.Cartitem;
import com.yutao.shi.service.Bookservice;
import com.yutao.shi.service.impl.BookserviceImpl;
import com.yutao.shi.utils.Webutils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shiyutao
 * @create 2021-10-27 15:47
 */
public class Cartservlet extends Baseservlet{
    private Bookservice bookservice=new BookserviceImpl();

    protected void additem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Webutils.parseint(req.getParameter("id"), 0);
        Book book = bookservice.querybook(id);
        Cartitem cartitem=new Cartitem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
        Cart cart=(Cart) req.getSession().getAttribute("cart");
        if(cart==null){
            cart=new Cart();
            req.getSession().setAttribute("cart",cart);
        }

        cart.additem(cartitem);
        req.getSession().setAttribute("lastname",cartitem.getName());
        resp.sendRedirect(req.getHeader("Referer"));

    }
    protected void ajaxadditem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Webutils.parseint(req.getParameter("id"), 0);
        Book book = bookservice.querybook(id);
        Cartitem cartitem=new Cartitem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
        Cart cart=(Cart) req.getSession().getAttribute("cart");
        if(cart==null){
            cart=new Cart();
            req.getSession().setAttribute("cart",cart);
        }

        cart.additem(cartitem);
        req.getSession().setAttribute("lastname",cartitem.getName());
        Map<String,Object>map=new HashMap<>();
        map.put("totalcount",cart.getTotalcount());
        map.put("lastname",cartitem.getName());
        Gson gson=new Gson();
        String s = gson.toJson(map);
        resp.getWriter().write(s);



    }






    protected void deleteitem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Webutils.parseint(req.getParameter("id"), 0);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.deleteitem(id);
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }
    protected void clean(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
          cart.clean();
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }
    protected void updatecount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Webutils.parseint(req.getParameter("id"), 0);
        int count = Webutils.parseint(req.getParameter("count"), 1);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.updatecount(id,count);
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }


}

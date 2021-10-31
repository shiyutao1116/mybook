package com.yutao.shi.web;

import com.google.gson.Gson;
import com.yutao.shi.pojo.Cart;
import com.yutao.shi.pojo.Order;
import com.yutao.shi.pojo.Orderitem;
import com.yutao.shi.pojo.User;
import com.yutao.shi.service.Bookservice;
import com.yutao.shi.service.Orderservice;
import com.yutao.shi.service.impl.OrderserviceImpl;
import com.yutao.shi.utils.JdbcU;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shiyutao
 * @create 2021-10-28 22:53
 */
public class Orderservlet extends Baseservlet {

    private Orderservice orderservice =new OrderserviceImpl();
    protected void createorder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart=(Cart) req.getSession().getAttribute("cart");
        User user=(User) req.getSession().getAttribute("user");

        if(user==null){
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }

        Integer id = user.getId();
        String orderid = orderservice.createorder(cart, id);
        req.getSession().setAttribute("orderid",orderid);

        resp.sendRedirect(req.getContextPath()+"/pages/cart/checkout.jsp");
    }

    protected void showallorders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> orders = orderservice.showallorders();
        req.setAttribute("orders",orders);
        req.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(req,resp);
    }
    protected void sendorder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        orderservice.sendorder(id);
        resp.sendRedirect(req.getContextPath()+"/orderservlet?action=showallorders");
    }
    protected void showorderdetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        List<Orderitem> orderitems = orderservice.showorderdetails(id);
        req.setAttribute("items",orderitems);
        req.getRequestDispatcher("/pages/manager/order_details.jsp").forward(req,resp);
    }
    protected void showmyorders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        List<Order> showmyorders = orderservice.showmyorders(id);
        System.out.println(showmyorders);
        req.setAttribute("orders",showmyorders);
        req.getRequestDispatcher("/pages/order/order.jsp").forward(req,resp);
    }
    protected void receiverorder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String personid = req.getParameter("personid");
        orderservice.receiveorder(id);
        System.out.println(id);

        resp.sendRedirect(req.getContextPath()+"/orderservlet?action=showmyorders&id="+personid);
    }
}


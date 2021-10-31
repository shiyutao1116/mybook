package com.yutao.shi.service.impl;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.yutao.shi.dao.BookDAO;
import com.yutao.shi.dao.OrderDAO;
import com.yutao.shi.dao.OrderitemDAO;
import com.yutao.shi.dao.impl.BookDAOimpl;
import com.yutao.shi.dao.impl.OrderDAOimpl;
import com.yutao.shi.dao.impl.OrderitemDAOimpl;
import com.yutao.shi.pojo.*;
import com.yutao.shi.service.Orderservice;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author shiyutao
 * @create 2021-10-28 22:36
 */
public class OrderserviceImpl implements Orderservice{
    private OrderDAO orderDAO=new OrderDAOimpl();
    private OrderitemDAO orderitemDAO=new OrderitemDAOimpl();
    private BookDAO bookDAO=new BookDAOimpl();
    @Override
    public String createorder(Cart cart, Integer userid) {
        String orderid=System.currentTimeMillis()+""+userid;
        Order order=new Order(orderid,new Date(),cart.getTotalprice(),0,userid);
        orderDAO.saveorder(order);
        for(Map.Entry<Integer,Cartitem>entry:cart.getItems().entrySet()){
            Cartitem cartitem=entry.getValue();
            Orderitem orderitem=new Orderitem(null,cartitem.getName(),cartitem.getCount(),cartitem.getPrice(),cartitem.getTotalprice(),orderid);
            orderitemDAO.saveorderitem(orderitem);
            Book book = bookDAO.querybookbyid(cartitem.getId());
            book.setSales(book.getSales()+cartitem.getCount());
            book.setStock(book.getStock()-cartitem.getCount());
            bookDAO.updatebook(book);

        }
        cart.clean();
        return orderid;
    }

    @Override
    public List<Order> showallorders() {
      return orderDAO.queryorders();
    }

    @Override
    public void sendorder(String orderid) {
        orderDAO.changeorderstatus(1,orderid);
    }

    @Override
    public List<Orderitem> showorderdetails(String orderid) {
        return orderitemDAO.queryorderitembyorderid(orderid);
    }

    @Override
    public List<Order> showmyorders(String userid) {
        return orderDAO.queryorderbyuserid(userid);
    }

    @Override
    public void receiveorder(String orderid) {
            orderDAO.changeorderstatus(2,orderid);
    }

}

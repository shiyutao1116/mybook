package com.yutao.shi.service;

import com.yutao.shi.pojo.Cart;
import com.yutao.shi.pojo.Order;
import com.yutao.shi.pojo.Orderitem;

import java.security.PublicKey;
import java.util.List;

/**
 * @author shiyutao
 * @create 2021-10-28 22:35
 */
public interface Orderservice {

    public String createorder(Cart cart,Integer userid);
    public List<Order> showallorders();
    public void sendorder(String orderid);
    public List<Orderitem> showorderdetails(String orderid);
    public List<Order> showmyorders(String userid);
    public void receiveorder(String orderid);


}

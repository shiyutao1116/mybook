package com.yutao.shi.dao;

import com.yutao.shi.pojo.Order;


import java.util.List;

/**
 * @author shiyutao
 * @create 2021-10-28 21:48
 */
public interface OrderDAO {

    public int saveorder(Order order);
    public List<Order> queryorders();
    public int changeorderstatus(Integer status,String orderid);
    public List<Order> queryorderbyuserid(String userid);
}

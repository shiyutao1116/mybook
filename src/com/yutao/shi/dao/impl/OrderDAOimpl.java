package com.yutao.shi.dao.impl;

import com.yutao.shi.dao.OrderDAO;
import com.yutao.shi.pojo.Order;

import java.util.List;

/**
 * @author shiyutao
 * @create 2021-10-28 22:03
 */
public class OrderDAOimpl extends BaseDAO implements OrderDAO{
    @Override
    public int saveorder(Order order){
        String sql="insert into t_order(`order_id`,`create_time`,`price`,`status`,`user_id`)values(?,?,?,?,?)";
        return update(sql,order.getOrderid(),order.getCreatetime(),order.getPrice(),order.getStatus(),order.getUserid());
    }

    @Override
    public List<Order> queryorders() {
       String sql="select `order_id` orderid,`create_time` createtime,`price`,`status`,`user_id` userid from t_order";
      return searchmany(Order.class,sql);
    }

    @Override
    public int changeorderstatus( Integer status,String orderid) {
        String sql="update t_order set `status`=? where `order_id`=?";
        return update(sql,status,orderid);

    }

    @Override
    public List<Order> queryorderbyuserid(String userid) {
        String sql="select `order_id` orderid,`create_time` createtime,`price`,`status`,`user_id` userid from t_order where `user_id` =?";
        return searchmany(Order.class,sql,userid);
    }


}

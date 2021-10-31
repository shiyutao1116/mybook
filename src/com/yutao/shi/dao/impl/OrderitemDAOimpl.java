package com.yutao.shi.dao.impl;

import com.yutao.shi.dao.OrderitemDAO;
import com.yutao.shi.pojo.Orderitem;

import java.util.List;

/**
 * @author shiyutao
 * @create 2021-10-28 22:03
 */
public class OrderitemDAOimpl extends BaseDAO implements OrderitemDAO{
    @Override
    public int saveorderitem(Orderitem orderitem) {
        String sql="insert into t_orderitem(`name`,`count`,`price`,`totalprice`,`order_id`)values(?,?,?,?,?)";
        return update(sql,orderitem.getName(),orderitem.getCount(),orderitem.getPrice(),orderitem.getTotalprice(),orderitem.getOrderid());
    }

    @Override
    public List<Orderitem> queryorderitembyorderid(String orderid) {
       String sql="select `id`,`name`,`count`,`price`,`totalprice`,`order_id` orderid from t_orderitem where `order_id`=?";
       return searchmany(Orderitem.class,sql,orderid);
    }
}

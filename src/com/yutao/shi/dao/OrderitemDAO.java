package com.yutao.shi.dao;

import com.yutao.shi.pojo.Order;
import com.yutao.shi.pojo.Orderitem;

import java.util.List;

/**
 * @author shiyutao
 * @create 2021-10-28 21:48
 */
public interface OrderitemDAO {
    public int saveorderitem(Orderitem orderitem);
    public List<Orderitem> queryorderitembyorderid(String orderid);


}

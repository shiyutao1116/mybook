package com.yutao.shi.test;

import com.yutao.shi.dao.OrderDAO;
import com.yutao.shi.dao.impl.OrderDAOimpl;
import com.yutao.shi.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author shiyutao
 * @create 2021-10-28 22:17
 */
public class OrderDAOimplTest {
OrderDAO orderDAO=new OrderDAOimpl();
    @Test
    public void saveorder() {
        orderDAO.saveorder(new Order("1",new Date(),new BigDecimal(100),0,1));

    }

    @Test
    public void queryorders() {
        System.out.println(orderDAO.queryorders());

    }

    @Test
    public void changeorderstatus() {
        System.out.println(orderDAO.changeorderstatus(1,"16354341583491"));
    }

    @Test
    public void queryorderbyuserid() {
        System.out.println(orderDAO.queryorderbyuserid("1"));
    }

}
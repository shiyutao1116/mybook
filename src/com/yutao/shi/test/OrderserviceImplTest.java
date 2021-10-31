package com.yutao.shi.test;

import com.yutao.shi.pojo.Cart;
import com.yutao.shi.pojo.Cartitem;
import com.yutao.shi.pojo.Orderitem;
import com.yutao.shi.service.Orderservice;
import com.yutao.shi.service.impl.OrderserviceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author shiyutao
 * @create 2021-10-28 22:50
 */
public class OrderserviceImplTest {
    private Orderservice orderservice=new OrderserviceImpl();
    @Test
    public void createorder() {
        Cart cart=new Cart();
        cart.additem(new Cartitem(1,"sss",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.additem(new Cartitem(1,"sss",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.additem(new Cartitem(2,"sssyyy",1,new BigDecimal(1000),new BigDecimal(1000)));
        Orderservice orderservice=new OrderserviceImpl();
        System.out.println(orderservice.createorder(cart, 1));

    }
    @Test
    public void showallorders() {
        System.out.println(orderservice.showallorders());

    }
    @Test
    public void sendorder() {
       orderservice.sendorder("16354861427101");

    }
    @Test
    public void showorderdetails() {
        System.out.println(orderservice.showorderdetails("1"));

    }
    @Test
    public void showmyorders() {
        System.out.println(orderservice.showmyorders("1"));

    }
    @Test
    public void receiveorder() {


    }

}
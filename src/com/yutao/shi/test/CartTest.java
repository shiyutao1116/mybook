package com.yutao.shi.test;

import com.yutao.shi.pojo.Cart;
import com.yutao.shi.pojo.Cartitem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author shiyutao
 * @create 2021-10-27 15:13
 */
public class CartTest {

    @Test
    public void additem() {
        Cart cart=new Cart();
        cart.additem(new Cartitem(1,"sss",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.additem(new Cartitem(1,"sss",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.additem(new Cartitem(2,"sssyyy",1,new BigDecimal(1000),new BigDecimal(1000)));
        System.out.println(cart);
    }

    @Test
    public void deleteitem() {
        Cart cart=new Cart();
        cart.additem(new Cartitem(1,"sss",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.additem(new Cartitem(1,"sss",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.additem(new Cartitem(2,"sssyyy",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.deleteitem(1);
        System.out.println(cart);

    }

    @Test
    public void clean() {
        Cart cart=new Cart();
        cart.additem(new Cartitem(1,"sss",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.additem(new Cartitem(1,"sss",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.additem(new Cartitem(2,"sssyyy",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.deleteitem(1);
        cart.clean();
        System.out.println(cart);
    }

    @Test
    public void updatecount() {
        Cart cart=new Cart();
        cart.additem(new Cartitem(1,"sss",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.additem(new Cartitem(1,"sss",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.additem(new Cartitem(2,"sssyyy",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.updatecount(1,23);
        System.out.println(cart);
    }
}
package com.yutao.shi.test;

import com.yutao.shi.dao.OrderitemDAO;
import com.yutao.shi.dao.impl.OrderitemDAOimpl;
import com.yutao.shi.pojo.Orderitem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author shiyutao
 * @create 2021-10-28 22:17
 */
public class OrderitemDAOimplTest {
    OrderitemDAO orderitemDAO=new OrderitemDAOimpl();
    @Test
    public void saveorderitem() {
        orderitemDAO.saveorderitem(new Orderitem(null,"侍宇韬自传",1,new BigDecimal(100),new BigDecimal(100),"1"));
        orderitemDAO.saveorderitem(new Orderitem(null,"宋方昀自传",1,new BigDecimal(900),new BigDecimal(900),"1"));

    }

    @Test
    public void queryorderitembyorderid() {
        System.out.println(orderitemDAO.queryorderitembyorderid("1"));
    }
}
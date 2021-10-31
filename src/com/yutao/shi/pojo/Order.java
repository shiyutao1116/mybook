package com.yutao.shi.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author shiyutao
 * @create 2021-10-28 21:27
 */
public class Order {
    private String orderid;
    private Date createtime;
    private BigDecimal price;
    private Integer status=0;
    private Integer userid;

    public Order() {
    }

    public Order(String orderid, Date createtime, BigDecimal price, Integer status, Integer userid) {
        this.orderid = orderid;
        this.createtime = createtime;
        this.price = price;
        this.status = status;
        this.userid = userid;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderid='" + orderid + '\'' +
                ", createtime=" + createtime +
                ", price=" + price +
                ", status=" + status +
                ", userid=" + userid +
                '}';
    }
}

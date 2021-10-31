package com.yutao.shi.pojo;

import java.math.BigDecimal;

/**
 * @author shiyutao
 * @create 2021-10-27 14:06
 */
public class Cartitem {

    private Integer id;
    private String  name;
    private Integer count;
    private BigDecimal price;
    private  BigDecimal totalprice;

    public Cartitem() {
    }

    public Cartitem(Integer id, String name, Integer count, BigDecimal price, BigDecimal totalprice) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
        this.totalprice = totalprice;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(BigDecimal totalprice) {
        this.totalprice = totalprice;
    }


    @Override
    public String toString() {
        return "Cartitem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", totalprice=" + totalprice +
                '}';
    }
}

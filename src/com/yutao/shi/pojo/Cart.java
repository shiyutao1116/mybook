package com.yutao.shi.pojo;

import com.jhlabs.image.FourColorFilter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shiyutao
 * @create 2021-10-27 14:08
 */
public class Cart {
    private Map<Integer,Cartitem> items=new LinkedHashMap<>();
//    private BigDecimal totalprice;
//    private Integer totalcount;
    public  void additem(Cartitem cartitem){
        Cartitem cartitem1 = items.get(cartitem.getId());
        if(cartitem1==null){
            items.put(cartitem.getId(),cartitem);
        }
        else {
            cartitem1.setCount(cartitem1.getCount()+1);
            cartitem1.setTotalprice(cartitem.getPrice().multiply(new BigDecimal(cartitem1.getCount())));

        }


    }
    public  void deleteitem(Integer id){
            items.remove(id);



    }
    public  void clean(){
            items.clear();



    }
    public  void updatecount(Integer id,Integer count){
        Cartitem item= items.get(id);
       if(item!=null){
            item.setCount(count);
           item.setCount(item.getCount()+1);
           item.setTotalprice(item.getPrice().multiply(new BigDecimal(item.getCount())));


       }



    }
    public Cart() {
    }

    public Cart(Map<Integer, Cartitem> items) {
        this.items = items;

    }

    public Map<Integer, Cartitem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, Cartitem> items) {
        this.items = items;
    }

    public BigDecimal getTotalprice() {
        BigDecimal totalprice=new BigDecimal(0);
        for(Map.Entry<Integer,Cartitem>entry:items.entrySet()){
            totalprice=totalprice.add(entry.getValue().getTotalprice());


        }

        return totalprice;
    }



    public Integer getTotalcount() {
        Integer totalcount=0;
        for(Map.Entry<Integer,Cartitem>entry:items.entrySet()){
       totalcount+=entry.getValue().getCount();

        }

        return totalcount;
    }


    @Override
    public String toString() {
        return "Cart{" +
                "items=" + items +
                ", totalprice=" + getTotalprice() +
                ", totalcount=" + getTotalcount() +
                '}';
    }
}

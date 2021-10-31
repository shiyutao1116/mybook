package com.yutao.shi.pojo;

import java.util.List;

/**
 * @author shiyutao
 * @create 2021-10-23 15:07
 */
public class Page<T> {
    public static Integer PAGE_SIZE=4;
    private Integer pageno;
    private Integer pagetotal;
    private Integer pagesize=PAGE_SIZE;
    private Integer Pagetotalcount;
    private List<T> items;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String url;

    public Integer getPageno() {
        return pageno;
    }

    public void setPageno(Integer pageno) {
        if(pageno<1){ pageno=1; }
        if(pageno>pagetotal){ pageno=pagetotal; }
        this.pageno = pageno;
    }

    public Integer getPagetotal() {
        return pagetotal;
    }

    public void setPagetotal(Integer pagetotal) {
        this.pagetotal = pagetotal;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    public void setPagesize(Integer pagesize) {
        this.pagesize = pagesize;
    }

    public Integer getPagetotalcount() {
        return Pagetotalcount;
    }

    public void setPagetotalcount(Integer pagetotalcount) {
        Pagetotalcount = pagetotalcount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageno=" + pageno +
                ", pagetotal=" + pagetotal +
                ", pagesize=" + pagesize +
                ", Pagetotalcount=" + Pagetotalcount +
                ", items=" + items +
                ", url='" + url + '\'' +
                '}';
    }
}

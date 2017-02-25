package com.example.domain;

/**
 * Created by Domg on 2016/12/3.
 */
public class Page extends BaseEntity {

    private int size = 20;
    private int total;
    private int pageNo;

    public int getPageTotal() {
        return total % size > 0 ? total / size + 1 : total / size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }
}

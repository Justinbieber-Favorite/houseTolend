package com.kgc.utils;

public class Page {
   // 封装的分页工具  代替pageHelper中的 page和rows
    private  Integer page=1;
    private  Integer rows=3;
    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}

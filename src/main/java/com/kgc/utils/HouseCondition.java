package com.kgc.utils;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class HouseCondition {
    //后台管理员界面 做审核用
    private String h_title;//标题
    private Date begin_pubdate;// 发布时间
    private Date end_pubdate;//发布时间
    private  Integer h_floorage;//房屋大小

    public Integer getH_floorage() {
        return h_floorage;
    }

    public void setH_floorage(Integer h_floorage) {
        this.h_floorage = h_floorage;
    }



    public String getH_title() {
        return h_title;
    }

    public void setH_title(String h_title) {
        this.h_title = h_title;
    }

    public Date getBegin_pubdate() {
        return begin_pubdate;
    }
@DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setBegin_pubdate(Date begin_pubdate) {
        this.begin_pubdate = begin_pubdate;
    }

    public Date getEnd_pubdate() {
        return end_pubdate;
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setEnd_pubdate(Date end_pubdate) {
        this.end_pubdate = end_pubdate;
    }

}

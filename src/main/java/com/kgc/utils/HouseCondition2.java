package com.kgc.utils;

public class HouseCondition2 extends Page {

    //前台用户界面条件查询
    private String  title;//标题
    private Integer typeid;//房屋类型
    private Integer districtid;//区域类型
    private  Integer streetid;//街道类型
    private  Integer min_price;//最低价格
    private  Integer max_price;//最高价格
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }


    public Integer getStreetid() {
        return streetid;
    }

    public void setStreetid(Integer streetid) {
        this.streetid = streetid;
    }

    public Integer getMin_price() {
        return min_price;
    }

    public void setMin_price(Integer min_price) {
        this.min_price = min_price;
    }

    public Integer getMax_price() {
        return max_price;
    }

    public void setMax_price(Integer max_price) {
        this.max_price = max_price;
    }



    public Integer getDistrictid() {
        return districtid;
    }

    public void setDistrictid(Integer districtid) {
        this.districtid = districtid;
    }




}

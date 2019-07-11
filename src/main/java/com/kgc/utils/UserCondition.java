package com.kgc.utils;

public class UserCondition extends Page{
    //后台管理员分页显示 查找管理员
    private String name;//姓名
    private String telephone;//电话
    private Integer min_age;//最小年龄
    private  Integer max_age;//最大年龄
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getMin_age() {
        return min_age;
    }

    public void setMin_age(Integer min_age) {
        this.min_age = min_age;
    }

    public Integer getMax_age() {
        return max_age;
    }

    public void setMax_age(Integer max_age) {
        this.max_age = max_age;
    }



}

package com.kgc.entity;

public class District {
    //洪山区
    private Integer id;//区域编号

    private String name;//区域名称

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
        this.name = name == null ? null : name.trim();
    }
}
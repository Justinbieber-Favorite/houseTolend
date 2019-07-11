package com.kgc.entity;

public class Type {
    //房屋类型,例如 三室一厅
    private Integer id;//类型编号

    private String name;//类型名称

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
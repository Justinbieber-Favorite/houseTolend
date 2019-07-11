package com.kgc.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class House {

    private String id;//房屋编号

    private Integer userId;//用户编号

    private Integer typeId;//房屋类型编号

    private String title;//房屋出租标题

    private String description;//详细

    private Long price;//房屋出租价格

    private Date pubdate;//发布日期

    private Integer floorage;//房屋面积

    private String contact;//联系方式

    private Integer streetId;//街道编号

    private Integer ispass;//是否通过审核  1通过 0 未通过

    private Integer isdel;//是否被发布者删除? 1 已删除  0  未删除
    private String path;//图片信息
    private String tname;  //类型名称
    private String dname; //区域名称
    private String sname; //街道名称
    private Integer did;  //用于关联house表和区域表所建的字段

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Date getPubdate() {
        return pubdate;
    }
@DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    public Integer getFloorage() {
        return floorage;
    }

    public void setFloorage(Integer floorage) {
        this.floorage = floorage;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public Integer getStreetId() {
        return streetId;
    }

    public void setStreetId(Integer streetId) {
        this.streetId = streetId;
    }

    public Integer getIspass() {
        return ispass;
    }

    public void setIspass(Integer ispass) {
        this.ispass = ispass;
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    }

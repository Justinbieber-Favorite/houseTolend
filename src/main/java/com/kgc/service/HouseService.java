package com.kgc.service;

import com.github.pagehelper.PageInfo;
import com.kgc.entity.House;
import com.kgc.utils.HouseCondition;
import com.kgc.utils.HouseCondition2;
import com.kgc.utils.Page;

import java.util.List;


public interface HouseService {
    public  int addHouse(House house);//添加房屋
    public int  updateHouse(House house);//修改房屋
   public PageInfo<House> getHousePageByUserId(Page page, Integer id);//根据用户编号,得到该用户所有的发布房屋的分页信息
    House getHouseById(String id);//得到某个房屋信息
    public  int delHouse(String id,Integer isdel);//删除某个房屋,假删除操作,即该删除字段值改为1
    public  int passHouse(String id,Integer ispass);//房屋审核操作
    public  int passMany(List<String> ids,Integer ispass);//后台管理员批量审核操作,该功能尚未完成!
    PageInfo<House> getHouseByYesPass(Integer isPass, Page page, HouseCondition  houseCondition);//后台带条件的房屋审核分页 审核通过和未通过两个分页显示
    PageInfo<House> getBrowiseHouse(HouseCondition2 houseCondition2);//带条件的房屋分页,前台用户界面.用户搜索房屋信息时用

}

package com.kgc.service;

import com.github.pagehelper.PageInfo;
import com.kgc.entity.House;
import com.kgc.utils.HouseCondition;
import com.kgc.utils.HouseCondition2;
import com.kgc.utils.Page;

import java.util.List;


public interface HouseService {
    public  int addHouse(House house);
    public int  updateHouse(House house);
   public PageInfo<House> getHousePageByUserId(Page page, Integer id);
    House getHouseById(String id);
    public  int delHouse(String id,Integer isdel);
    public  int passHouse(String id,Integer ispass);
    public  int passMany(List<String> ids,Integer ispass);
    PageInfo<House> getHouseByYesPass(Integer isPass, Page page, HouseCondition  houseCondition);
    PageInfo<House> getBrowiseHouse(HouseCondition2 houseCondition2);

}

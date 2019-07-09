package com.kgc.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.entity.House;
import com.kgc.entity.HouseExample;
import com.kgc.mapper.HouseMapper;
import com.kgc.service.HouseService;
import com.kgc.utils.HouseCondition;
import com.kgc.utils.HouseCondition2;
import com.kgc.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class HouseServiceImpl  implements HouseService {
    @Autowired
    private HouseMapper houseMapper;
     @Override
    public int addHouse(House house) {
        return houseMapper.insertSelective(house);
    }

    @Override
    public int updateHouse(House house) {
        return houseMapper.updateByPrimaryKeySelective(house);
    }

    @Override
    public PageInfo<House> getHousePageByUserId(Page page, Integer id) {
        PageHelper.startPage(page.getPage(),page.getRows());
        List<House> list = houseMapper.getHouseByUserId(id);
        return new PageInfo<>(list);
    }

    @Override
    public House getHouseById(String id) {
        return houseMapper.getHouseById(id);
    }

    @Override
    public int delHouse(String id, Integer isdel) {
   House house=new House();
   house.setId(id);
   house.setIsdel(isdel);
     return    houseMapper.updateByPrimaryKeySelective(house);

    }

    @Override
    public int passHouse(String id, Integer ispass) {

         House house=new House();
         house.setIspass(ispass);
         house.setId(id);

        return houseMapper.updateByPrimaryKeySelective(house);
    }

    @Override
    public int passMany(List<String> ids, Integer ispass) {
        return houseMapper.ispassmany(ids, ispass);
    }

    @Override
    public PageInfo<House> getHouseByYesPass(Integer isPass, Page page, HouseCondition houseCondition) {
         PageHelper.startPage(page.getPage(),page.getRows());
        HouseExample example=new HouseExample();
        HouseExample.Criteria criteria = example.createCriteria();
        if(houseCondition.getH_title()!=null){
criteria.andTitleLike("%"+houseCondition.getH_title()+"%");
        }
        if(houseCondition.getBegin_pubdate()!=null){
            criteria.andPubdateGreaterThanOrEqualTo(houseCondition.getBegin_pubdate());
        }
        if(houseCondition.getEnd_pubdate()!=null){
            criteria.andPubdateLessThanOrEqualTo(houseCondition.getEnd_pubdate());
        }
        if(houseCondition.getH_floorage()!=null){
            criteria.andFloorageEqualTo(houseCondition.getH_floorage());
        }
        List<House> info = houseMapper.getHouseByYesPass(isPass);
        return new PageInfo<>(info);
    }

    @Override
    public PageInfo<House> getBrowiseHouse(HouseCondition2 houseCondition2) {
         PageHelper.startPage(houseCondition2.getPage(),houseCondition2.getRows());
        List<House> list = houseMapper.getBrowiseHouse(houseCondition2);
        PageInfo<House> info=new PageInfo<>(list);
        return info;
    }


}

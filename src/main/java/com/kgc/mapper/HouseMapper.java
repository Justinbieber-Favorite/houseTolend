package com.kgc.mapper;

import com.kgc.entity.House;
import com.kgc.entity.HouseExample;
import com.kgc.utils.HouseCondition2;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HouseMapper {
    int countByExample(HouseExample example);

    int deleteByExample(HouseExample example);

    int deleteByPrimaryKey(String id);

    int insert(House record);

    int insertSelective(House record);

    List<House> selectByExample(HouseExample example);

    House selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") House record, @Param("example") HouseExample example);

    int updateByExample(@Param("record") House record, @Param("example") HouseExample example);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);
    public List<House> getHouseByUserId(Integer userid);
    House getHouseById(String id);
    List<House> getHouseByYesPass(Integer isPass);
int ispassmany(List<String> ids,Integer idpass);


List<House> getBrowiseHouse(HouseCondition2 houseCondition2);

}
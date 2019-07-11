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
    public List<House> getHouseByUserId(Integer userid);//通过用户编号来查找所有房屋信息
    House getHouseById(String id);//通过房屋表的房子编号来查找某个房屋信息
    List<House> getHouseByYesPass(Integer isPass);//通过是否通过审核这一条件来查找所有房屋,即分为两个list集合   审核通过和审核未通过的
int ispassmany(List<String> ids,Integer idpass);//批量提交审核 ,管理员批量审核通过 或者批量审核不通过   !!!!!此功能不可用 ,存在bug!!


List<House> getBrowiseHouse(HouseCondition2 houseCondition2);//带条件的分页查询所有房屋信息

}
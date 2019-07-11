package com.kgc.mapper;

import com.kgc.entity.Users;
import com.kgc.entity.UsersExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsersMapper {
        int countByExample(UsersExample example);

        int deleteByExample(UsersExample example);

        int deleteByPrimaryKey(Integer id);

        int insert(Users record);

        int insertSelective(Users record);

        List<Users> selectByExample(UsersExample example);

        Users selectByPrimaryKey(Integer id);

        int updateByExampleSelective(@Param("record") Users record, @Param("example") UsersExample example);

        int updateByExample(@Param("record") Users record, @Param("example") UsersExample example);

        int updateByPrimaryKeySelective(Users record);

        int updateByPrimaryKey(Users record);
        int deletemoreUser(List<Integer> ids);//批量删除管理员,主要用于后台管理员,与用户无关
        }
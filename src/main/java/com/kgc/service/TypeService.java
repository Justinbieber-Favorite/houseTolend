package com.kgc.service;

import com.github.pagehelper.PageInfo;
import com.kgc.entity.Type;
import com.kgc.utils.Page;

import java.util.List;

public interface TypeService {
    public PageInfo<Type> getByPage(Page page);//房屋类型分页
    public  int addType(Type type);//添加房屋类型
    public  int updateType(Type type);//修改房屋类型
    public  int deleteType(Integer id);//删除房屋类型
    public  int deleteTypeList(List<Integer> ids);//批量删除房屋类型
    public Type getTypeById(Integer id);//通过房屋编号得到该房屋类型信息
    List<Type> getTypeList();//得到所有类型集合
}

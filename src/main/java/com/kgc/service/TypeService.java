package com.kgc.service;

import com.github.pagehelper.PageInfo;
import com.kgc.entity.Type;
import com.kgc.utils.Page;

import java.util.List;

public interface TypeService {
    public PageInfo<Type> getByPage(Page page);
    public  int addType(Type type);
    public  int updateType(Type type);
    public  int deleteType(Integer id);
    public  int deleteTypeList(List<Integer> ids);
    public Type getTypeById(Integer id);
    List<Type> getTypeList();
}

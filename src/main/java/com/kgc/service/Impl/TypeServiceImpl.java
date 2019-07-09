package com.kgc.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.entity.Type;
import com.kgc.entity.TypeExample;
import com.kgc.mapper.TypeMapper;
import com.kgc.service.TypeService;
import com.kgc.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
@Autowired
private TypeMapper typeMapper;

    @Override
    public PageInfo<Type> getByPage(Page page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        TypeExample example=new TypeExample();
        List<Type> list = typeMapper.selectByExample(example);
        PageInfo<Type> info = new PageInfo<>(list);
        return info;
    }

    @Override
    public int addType(Type type) {
        return typeMapper.insertSelective(type);
    }

    @Override
    public int updateType(Type type) {
        return typeMapper.updateByPrimaryKeySelective(type);
    }

    @Override
    public int deleteType(Integer id) {
        return typeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteTypeList(List<Integer> ids) {
        return typeMapper.deletemoreType(ids);
    }

    @Override
    public Type getTypeById(Integer id) {
        return typeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Type> getTypeList() {

        return typeMapper.selectByExample(new TypeExample());
    }

}

package com.kgc.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.entity.Street;
import com.kgc.entity.StreetExample;
import com.kgc.mapper.StreetMapper;
import com.kgc.service.StreetService;
import com.kgc.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetServiceImpl implements StreetService {
    @Autowired
    private StreetMapper streetMapper;
    @Override
    public PageInfo<Street> getByPage(Integer id,Page page) {
        PageHelper.startPage(page.getPage(),page.getRows());
        StreetExample example=new StreetExample();
        StreetExample.Criteria criteria = example.createCriteria();
        criteria.andDistrictIdEqualTo(id);
        List<Street> list = streetMapper.selectByExample(example);
        return new PageInfo<>(list);
    }

    @Override
    public int addStreet(Street street) {
        return streetMapper.insertSelective(street);
    }

    @Override
    public int updateStreet(Street street) {
        return streetMapper.updateByPrimaryKeySelective(street);
    }

    @Override
    public int deleteStreet(Integer id) {
        return streetMapper.deleteStreet(id);
    }

    @Override
    public Street getStreetById(Integer id) {
        return streetMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Street> getStreetList(Integer id) {
        StreetExample example=new StreetExample();
        StreetExample.Criteria criteria = example.createCriteria();
        criteria.andDistrictIdEqualTo(id);
        return  streetMapper.selectByExample(example);
    }
}

package com.kgc.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.entity.District;
import com.kgc.entity.DistrictExample;
import com.kgc.mapper.DistrictMapper;
import com.kgc.mapper.StreetMapper;
import com.kgc.service.DistrictService;
import com.kgc.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictMapper districtMapper;
    @Autowired
    private StreetMapper streetMapper;

    @Override
    public PageInfo<District> getByPage(Page page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        DistrictExample example = new DistrictExample();
        example.setOrderByClause("id DESC");
        List<District> list = districtMapper.selectByExample(example);
        PageInfo<District> info = new PageInfo<>(list);
        return info;
    }

    @Override
    public int addDistrict(District district) {
        return districtMapper.insertSelective(district);
    }

    @Override
    public int updateDistrict(District district) {
        return districtMapper.updateByPrimaryKeySelective(district);
    }

    @Override
    @Transactional
    public int deleteDistrict(Integer id) {
streetMapper.deleteStreet(id);

     districtMapper.deleteByPrimaryKey(id);
     return 1;
    }

    @Override
    public int deleteDistrictList(List<Integer> ids) {
        return districtMapper.deletemoreDistrict(ids);
    }


    @Override
    public District getSingle(Integer id) {
        return districtMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<District> getDistrictList() {

        return districtMapper.selectByExample(new DistrictExample());
    }
}

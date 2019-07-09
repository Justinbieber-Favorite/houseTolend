package com.kgc.service;

import com.github.pagehelper.PageInfo;
import com.kgc.entity.District;
import com.kgc.utils.Page;

import java.util.List;

public interface DistrictService {
  public   PageInfo<District> getByPage(Page page);
  public  int addDistrict(District district);
  public  int updateDistrict(District district);
  public  int deleteDistrict(Integer id);
  public  int deleteDistrictList(List<Integer> ids);
  public District getSingle(Integer id);
List<District> getDistrictList();

}

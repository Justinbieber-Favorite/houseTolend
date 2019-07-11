package com.kgc.service;

import com.github.pagehelper.PageInfo;
import com.kgc.entity.District;
import com.kgc.utils.Page;

import java.util.List;

public interface DistrictService {
  public   PageInfo<District> getByPage(Page page);//不带条件的区域分页
  public  int addDistrict(District district);//添加区域
  public  int updateDistrict(District district);//修改区域
  public  int deleteDistrict(Integer id);//删除某个区域
  public  int deleteDistrictList(List<Integer> ids);//批量删除区域
  public District getSingle(Integer id);//得到某个区域的信息
List<District> getDistrictList();//查询所有区域信息

}

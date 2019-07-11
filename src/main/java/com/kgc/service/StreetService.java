package com.kgc.service;

import com.github.pagehelper.PageInfo;
import com.kgc.entity.Street;
import com.kgc.utils.Page;

import java.util.List;


public interface StreetService {
  public   PageInfo<Street> getByPage(Integer disid,Page page);//街道分页,通过区域查找区域下的所有街道
  public  int addStreet(Street street);//添加街道
  public  int updateStreet(Street street);//修改街道
  public  int deleteStreet(Integer id);//删除街道
  public Street getStreetById(Integer id);//得到某个街道的所有信息
  List<Street>  getStreetList(Integer id);//通过区域查找该区域下的所有街道集合

}

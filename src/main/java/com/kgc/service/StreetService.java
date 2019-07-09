package com.kgc.service;

import com.github.pagehelper.PageInfo;
import com.kgc.entity.Street;
import com.kgc.utils.Page;

import java.util.List;


public interface StreetService {
  public   PageInfo<Street> getByPage(Integer disid,Page page);
  public  int addStreet(Street street);
  public  int updateStreet(Street street);
  public  int deleteStreet(Integer id);
  public Street getStreetById(Integer id);
  List<Street>  getStreetList(Integer id);

}

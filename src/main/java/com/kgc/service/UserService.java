package com.kgc.service;

import com.github.pagehelper.PageInfo;
import com.kgc.entity.Users;
import com.kgc.utils.UserCondition;

import java.util.List;

public interface UserService {
  public   PageInfo<Users> getByPage(UserCondition userCondition);
  public  int addUser(Users users);
  public  int updateUser(Users users);
  public  int deleteUser(Integer id);
  public  int deleteUserList(List<Integer> ids);
  public Users getUserById(Integer id);
  public int checkUser(String name);
  public  Users login(String name,String password);

}

package com.kgc.service;

import com.github.pagehelper.PageInfo;
import com.kgc.entity.Users;
import com.kgc.utils.UserCondition;

import java.util.List;

public interface UserService {
  public   PageInfo<Users> getByPage(UserCondition userCondition);//用户带条件的分页
  public  int addUser(Users users);//添加用户
  public  int updateUser(Users users);//修改用户
  public  int deleteUser(Integer id);//删除用户
  public  int deleteUserList(List<Integer> ids);//批量删除用户
  public Users getUserById(Integer id);//得到用户信息
  public int checkUser(String name);//做注册用户时用,检查是否存在该用户
  public  Users login(String name,String password);//用户登录验证!!   后面有加短信验证功能

}

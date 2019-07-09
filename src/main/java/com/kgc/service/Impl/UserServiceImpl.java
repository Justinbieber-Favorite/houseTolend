package com.kgc.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.entity.Users;
import com.kgc.entity.UsersExample;
import com.kgc.mapper.UsersMapper;
import com.kgc.service.UserService;
import com.kgc.utils.MD5Utils;
import com.kgc.utils.UserCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
@Autowired
private UsersMapper usersMapper;
    @Override
    public PageInfo<Users> getByPage(UserCondition userCondition) {
        PageHelper.startPage(userCondition.getPage(),userCondition.getRows());
        UsersExample example=new UsersExample();
        example.setOrderByClause("id DESC");
        UsersExample.Criteria criteria = example.createCriteria();
        criteria.andIsadminEqualTo(1);
        if(userCondition.getName()!=null){
            criteria.andNameLike("%"+userCondition.getName()+"%");
        }
        if(userCondition.getTelephone()!=null){
            criteria.andTelephoneLike("%"+userCondition.getTelephone()+"%");
        }
        if(userCondition.getMin_age()!=null){
            criteria.andAgeGreaterThanOrEqualTo(userCondition.getMin_age());
        }
        if(userCondition.getMax_age()!=null){
            criteria.andAgeLessThanOrEqualTo(userCondition.getMax_age());
        }
        List<Users> list = usersMapper.selectByExample(example);

        return new PageInfo<>(list);
    }

    @Override
    public int addUser(Users users) {
        String password = MD5Utils.md5Encrypt(users.getPassword());
        users.setPassword(password);
        return usersMapper.insertSelective(users);
    }

    @Override
    public int updateUser(Users users) {
        return usersMapper.updateByPrimaryKeySelective(users);
    }

    @Override
    public int deleteUser(Integer id) {
        return usersMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteUserList(List<Integer> ids) {
        return usersMapper.deletemoreUser(ids);
    }

    @Override
    public Users getUserById(Integer id) {
        return usersMapper.selectByPrimaryKey(id);
    }

    @Override
    public int checkUser(String name) {
        UsersExample example=new UsersExample();
        UsersExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name);
        criteria.andIsadminEqualTo(0);
        List<Users> list = usersMapper.selectByExample(example);
        return list.size();
    }

    @Override
    public Users login(String name, String password) {
        UsersExample example=new UsersExample();
        UsersExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name);
        criteria.andPasswordEqualTo(MD5Utils.md5Encrypt(password));
        List<Users> list = usersMapper.selectByExample(example);
        if (list.size()==0){
            return null;
        }else {
            return list.get(0);
        }
    }
}

package com.kgc.controller;

import com.github.pagehelper.PageInfo;
import com.kgc.entity.Users;
import com.kgc.service.UserService;
import com.kgc.utils.UserCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

;

@Controller
@RequestMapping("/admin/")
public class UserControllAll {
    @Autowired
    private UserService userService;
    @RequestMapping("getUser")
    @ResponseBody
    public Map<String, Object> list(UserCondition userCondition) {
        PageInfo<Users> info = userService.getByPage(userCondition);
        Map<String, Object> map = new HashMap<>();
        map.put("total", info.getTotal());
        map.put("rows", info.getList());
        return map;
    }

    @RequestMapping("addUser")
    @ResponseBody
    public String getUser(Users users) {
        int b = userService.addUser(users);
        return "{\"result\":" + b + "}";
    }

    @RequestMapping("updateUsers")
    @ResponseBody
    public String updateUsers(Users users) {
        int b = userService.updateUser(users);
        return "{\"result\":" + b + "}";
    }

    @RequestMapping("getUsersSingle")
    @ResponseBody
    public Users getSingle(Integer id) {
        return userService.getUserById(id);
    }

    //单条删除
    @RequestMapping("DeleteSingleUser")
    @ResponseBody
    public String deleteSingle(Integer id) {
        int b = userService.deleteUser(id);
        /*     System.out.println("66666");*/
        return "{\"result\":" + b + "}";
    }


    //批量删除
    @RequestMapping("DeleteMoreUsers")
    @ResponseBody
    public String deleteMany(String id) {//id=4,5,6...
        String[] strings = id.split(",");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            list.add(Integer.parseInt(strings[i]));//分别list.add(4),list.add(5),list.add(6)....
        }
        int b = userService.deleteUserList(list);

        return "{\"result\":" + b + "}";
    }
}

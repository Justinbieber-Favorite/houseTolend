package com.kgc.controller;

import com.github.pagehelper.PageInfo;
import com.kgc.entity.House;
import com.kgc.service.HouseService;
import com.kgc.utils.HouseCondition;
import com.kgc.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("/admin/")
public class HouseController2 {
    @Autowired
    private HouseService houseService;

@RequestMapping("HouseYesPass")
@ResponseBody
    public Map<String,Object> getHousenoPass( Page page,HouseCondition houseCondition){
        PageInfo<House> housepass = houseService.getHouseByYesPass(1, page,houseCondition);
        Map<String,Object> map=new HashMap<>();
        map.put("rows",housepass.getList());
        map.put("total",housepass.getTotal());
        return map;
    }

    @RequestMapping("HouseNoPass")
    @ResponseBody
    public Map<String,Object> getHouseisPass(Page page,HouseCondition houseCondition){
        PageInfo<House> housepass = houseService.getHouseByYesPass(0, page,houseCondition );
        Map<String,Object> map=new HashMap<>();
        map.put("rows",housepass.getList());
        map.put("total",housepass.getTotal());
        return map;
    }

    @RequestMapping("CheckSuccess")
    @ResponseBody
    public String success(String id){
        int temp=houseService.passHouse(id,1);
        return "{\"result\":"+temp+"}";
    }
    @RequestMapping("CheckFail")
    @ResponseBody
    public String fail(String id){
        int temp = houseService.passHouse(id, 0);
return "{\"result\":"+temp+"}";
    }

    ///以下是批量操作
    @RequestMapping("CheckAllSuccess")
    @ResponseBody
    public String allsuccess(String ids){
        String[] strings = ids.split(",");
        List<String> list= Arrays.asList(strings);
        int temp = houseService.passMany(list, 1);
        return "{\"result\":"+temp+"}";
    }

    @RequestMapping("CheckAllFail")
    @ResponseBody
    public String allfail(String ids){
        System.out.println(ids);
        String[] strings = ids.split(",");
        List<String> list= Arrays.asList(strings);
        int temp = houseService.passMany(list, 0);
        return "{\"result\":"+temp+"}";
    }

}

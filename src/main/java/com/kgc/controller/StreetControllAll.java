package com.kgc.controller;

import com.github.pagehelper.PageInfo;
import com.kgc.entity.District;
import com.kgc.entity.Street;
import com.kgc.service.DistrictService;
import com.kgc.service.StreetService;
import com.kgc.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/")
public class StreetControllAll {
    @Autowired
    private StreetService streetService;
    @RequestMapping("getStreet")
    @ResponseBody
    public Map<String, Object> list(Integer id,Page page) {
        PageInfo<Street> info = streetService.getByPage(id,page);
        Map<String, Object> map = new HashMap<>();
        map.put("total", info.getTotal());
        map.put("rows", info.getList());
        return map;
    }

    @RequestMapping("addStreet")
    @ResponseBody
    public String getStreet(Street street) {
        int b = streetService.addStreet(street);
        return "{\"result\":" + b + "}";
    }

    @RequestMapping("updateStreet")
    @ResponseBody
    public String updateStreet(Street street) {
        int b = streetService.updateStreet(street);
        return "{\"result\":" + b + "}";
    }

    @RequestMapping("getStreetSingle")
    @ResponseBody
    public Street getSingle(Integer id) {
        return streetService.getStreetById(id);
    }

    //单条删除
    @RequestMapping("DeleteSingleStreet")
    @ResponseBody
    public String deleteSingle(Integer id) {
        int b = streetService.deleteStreet(id);
        /*     System.out.println("66666");*/
        return "{\"result\":" + b + "}";
    }



}

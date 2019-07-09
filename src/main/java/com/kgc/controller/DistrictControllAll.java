package com.kgc.controller;

import com.github.pagehelper.PageInfo;
import com.kgc.entity.District;
import com.kgc.service.DistrictService;
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
public class DistrictControllAll {
    @Autowired
    private DistrictService districtService;

    @RequestMapping("getDistrict")
    @ResponseBody
    public Map<String, Object> list(Page page) {
        PageInfo<District> info = districtService.getByPage(page);
        Map<String, Object> map = new HashMap<>();
        map.put("total", info.getTotal());
        map.put("rows", info.getList());
        return map;
    }

    @RequestMapping("addDistrict")
    @ResponseBody
    public String getDistrict(District district) {
        int b = districtService.addDistrict(district);
        return "{\"result\":" + b + "}";
    }

    @RequestMapping("updateDistrict")
    @ResponseBody
    public String updateDistrict(District district) {
        int b = districtService.updateDistrict(district);
        return "{\"result\":" + b + "}";
    }

    @RequestMapping("getDistrictSingle")
    @ResponseBody
    public District getSingle(Integer id) {
        return districtService.getSingle(id);
    }

    //单条删除
    @RequestMapping("DeleteSingleDistrict")
    @ResponseBody
    public String deleteSingle(Integer id) {
        int b = districtService.deleteDistrict(id);
        /*     System.out.println("66666");*/
        return "{\"result\":" + b + "}";
    }


    //批量删除
    @RequestMapping("DeleteMoreDistrict")
    @ResponseBody
    public String deleteMany(String id) {//id=4,5,6...
        String[] strings = id.split(",");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            list.add(Integer.parseInt(strings[i]));//分别list.add(4),list.add(5),list.add(6)....
        }
        int b = districtService.deleteDistrictList(list);

        return "{\"result\":" + b + "}";
    }
}

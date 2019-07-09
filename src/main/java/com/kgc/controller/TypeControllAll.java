package com.kgc.controller;

import com.github.pagehelper.PageInfo;
import com.kgc.entity.Type;
import com.kgc.service.TypeService;
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
public class TypeControllAll {
    @Autowired
    private TypeService typeService;

    @RequestMapping("getType")
    @ResponseBody
    public Map<String, Object> list(Page page) {
        PageInfo<Type> info = typeService.getByPage(page);
        Map<String, Object> map = new HashMap<>();
        map.put("total", info.getTotal());
        map.put("rows", info.getList());
        return map;
    }

    @RequestMapping("addType")
    @ResponseBody
    public String getDistrict(Type type) {
        int b = typeService.addType(type);
        return "{\"result\":" + b + "}";
    }

    @RequestMapping("updateType")
    @ResponseBody
    public String updateDistrict(Type type) {
        int b = typeService.updateType(type);
        return "{\"result\":" + b + "}";
    }

    @RequestMapping("getTypeSingle")
    @ResponseBody
    public Type getSingle(Integer id) {
        return typeService.getTypeById(id);
    }

    //单条删除
    @RequestMapping("DeleteSingleType")
    @ResponseBody
    public String deleteSingle(Integer id) {
        int b = typeService.deleteType(id);
        return "{\"result\":" + b + "}";
    }


    //批量删除
    @RequestMapping("DeleteMoreType")
    @ResponseBody
    public String deleteMany(String id) {//id=4,5,6...
        String[] strings = id.split(",");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            list.add(Integer.parseInt(strings[i]));//分别list.add(4),list.add(5),list.add(6)....
        }
        int b = typeService.deleteTypeList(list);

        return "{\"result\":" + b + "}";
    }
}

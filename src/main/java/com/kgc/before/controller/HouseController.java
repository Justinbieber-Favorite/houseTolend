package com.kgc.before.controller;


import com.github.pagehelper.PageInfo;
import com.kgc.entity.*;
import com.kgc.service.*;
import com.kgc.utils.HouseCondition2;
import com.kgc.utils.MessageUtils;
import com.kgc.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/page/")
public class HouseController {
    @Autowired
    private TypeService typeService;
    @Autowired
    private DistrictService districtService;
    @Autowired
    private StreetService  streetService;
@Autowired
private HouseService houseService;
    @RequestMapping("getFabu")
    public String   getTypelist(Model model){
    List<Type> list = typeService.getTypeList();
    List<District> list1 = districtService.getDistrictList();
    model.addAttribute("types",list);
    model.addAttribute("districts",list1);
return "fabu";
}
    @RequestMapping("getStreetByDid")
    @ResponseBody
    public List<Street>   getTypelist(Integer id){
        Street street=new Street();
        street.setDistrictId(-1);
        List<Street> hhh = streetService.getStreetList(id);
        return hhh;
    }
    @RequestMapping("addHouse")
    public  String addHouse(Model model,House house, HttpSession session, @RequestParam(name = "cpath",required = false) CommonsMultipartFile cpath) throws IOException {
        String filename = cpath.getOriginalFilename();//文件名
        String kzm = filename.substring(filename.lastIndexOf("."));//扩展名
        String wjm = System.currentTimeMillis() + kzm;//保存的新的文件名
        String path="D:/image/"+wjm;//保存文件的路径
        File saveFile=new File(path);

        cpath.transferTo(saveFile);//文件上传
house.setId(System.currentTimeMillis()+"");//设置文件的编号,以便于存储于数据库中
        Users user= (Users) session.getAttribute("logininfo");
        house.setUserId(user.getId());//保存用户id,即登录的用户发布的出租信息
house.setPath(wjm);//设置保存数据库中图片的文件名称,即保存图片所用的区分编号
        int temp = houseService.addHouse(house);

        if(temp>0){
            model.addAttribute("info","发布成功!");
            return "guanli";//发布成功!跳转到guanli.jsp页面
        }else {
            saveFile.delete();//发布失败,删除上传的图片
            model.addAttribute("info","发布失败!");
            return "guanli";//
        }

    }
    @RequestMapping("getHouse")
public String getHouse(Page page,HttpSession session,Model model){
        Users users = (Users) session.getAttribute("logininfo");
        Integer id = users.getId();
        PageInfo<House> pageinfo = houseService.getHousePageByUserId(page,id);
     model.addAttribute("infoo",pageinfo);
     return "guanli";
    }

    @RequestMapping("uphouse")
    public String goupdate(String id,Model model){
        House house = houseService.getHouseById(id);
        model.addAttribute("house",house);
        return "upfabu";
    }

    @RequestMapping("getAllType")
    @ResponseBody
    public List<Type> getAllType(){
      return typeService.getTypeList();
    }
    @RequestMapping("getAllDistrict")
    @ResponseBody
    public List<District> getAllDistrict(){
      return districtService.getDistrictList();
    }


    @RequestMapping("updateHouse")
    public  String FinalUPdate(String oldPath,House house, @RequestParam(name = "pfile",required = false) CommonsMultipartFile pfile) throws IOException {
            String filename = pfile.getOriginalFilename();//文件名
        System.out.println(house);
        if(!filename.equals("")){
            String kzm = filename.substring(filename.lastIndexOf("."));//扩展名
            String wjm = System.currentTimeMillis() + kzm;//保存的新的文件名
            String path="d:/image/"+wjm;//保存文件的路径
            File saveFile=new File(path);
            pfile.transferTo(saveFile);//文件上传
            new File("d://image//"+oldPath).delete();
           house.setPath(wjm);
        }
      houseService.updateHouse(house);
        return "redirect:getHouse";
    }


    @RequestMapping("delhouse")
    public String delhouse(String id){
        houseService.delHouse(id, 1);
        return "redirect:getHouse";
    }

    @RequestMapping("getBrowiseHouse")
    public  String  getBrowiseHouse(HouseCondition2 houseCondition2,Model model){
        PageInfo<House> pageInfo = houseService.getBrowiseHouse(houseCondition2);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("condition",houseCondition2);
return "list";
    }
@RequestMapping("housedetail")
    public  String getHouse(String id,Model model){
    House house = houseService.getHouseById(id);
    model.addAttribute("house",house);
    return "details";

}
//验证登录
    @RequestMapping("getCode")
    @ResponseBody
    public  String getCode(String telphone,HttpSession session){
       String  code =(int) (Math.random() * 100000)+"";//获得一个随机生成的数

       String sengMsg="您的手机验证码是:"+code+",请在两分钟内输入!";
        int result = MessageUtils.sendMsg(sengMsg, telphone);

session.setAttribute("savecode",code);
session.setMaxInactiveInterval(120);//2分钟
        return "{\"result\":"+result +"}";

    }


}

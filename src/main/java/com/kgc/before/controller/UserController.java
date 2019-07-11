package com.kgc.before.controller;

import com.kgc.entity.Users;
import com.kgc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/page/")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("Check")
    @ResponseBody
    public String check(String name) {
        int b = userService.checkUser(name);
        return "{\"result\":" + b + "}";

    }

    @RequestMapping("reg")
    public String reg(Users user) {
        int i = userService.addUser(user);
        if (i > 0) {
            return "login";
        } else {
            return "regs";
        }
    }
//以下是短信验证功能,暂且不用
/*    @RequestMapping("LoginAction")
    public String login(String smstext,String name, String password, Model model, HttpSession session) {
        String savecode =(String) session.getAttribute("savecode");

        if(savecode.equals(smstext)){
            Users user = userService.login(name, password);
            if (user == null) {
                model.addAttribute("info", "用户名或密码输入有误!");
                return "login";
            } else {
                session.setAttribute("logininfo", user);
                session.setMaxInactiveInterval(600);//10分钟
                return "redirect:getHouse";
            }
        }else {
            model.addAttribute("info","验证码错误或验证码已过期,请重试!!");
            return "login";

        }


    }*/
    @RequestMapping("LoginAction")
    public String login(String name, String password, Model model, HttpSession session) {
        Users user = userService.login(name, password);
        if (user == null) {
            model.addAttribute("info", "用户名或密码输入有误!");
            return "login";
        } else {
            session.setAttribute("logininfo", user);
            session.setMaxInactiveInterval(600);//10分钟
            return "redirect:getHouse";
        }

    }
}

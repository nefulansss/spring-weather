package com.nefu.spring.weather.controller;

import com.nefu.spring.weather.service.UserService;
import com.nefu.spring.weather.entity.WUser;
import com.nefu.spring.weather.util.JsonResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: spring-weather
 * @description:
 * @author: nefulan
 * @create: 2020-03-21 15:57
 **/
@Service
@ResponseBody
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("login")
    public JsonResult login(@Param("user") WUser wUser){
        Boolean login;
        if (wUser!=null){
            login = userService.login(wUser);
        }else {
            return new JsonResult("登陆失败");
        }
        if (login){
            return new JsonResult("登陆成功");
        }else{
            return new JsonResult("登陆失败");
        }
    }


}

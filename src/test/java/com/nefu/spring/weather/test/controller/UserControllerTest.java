package com.nefu.spring.weather.test.controller;

import com.nefu.spring.weather.controller.UserController;
import com.nefu.spring.weather.SpringWeahterApplication;
import com.nefu.spring.weather.entity.WUser;
import com.nefu.spring.weather.util.JsonResult;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: spring-weather
 * @description:
 * @author: nefulan
 * @create: 2020-03-21 16:24
 **/
@SpringBootTest(classes = SpringWeahterApplication.class)
@RunWith(SpringRunner.class)
public class UserControllerTest {

    @Autowired
    private UserController userController;


    @Test
    public void testlogin(){
        WUser user = new WUser();
        user.setUserName("root");
        user.setPassword("root");
        JsonResult login = userController.login(user);
        Assert.assertNotNull(login);

    }

}

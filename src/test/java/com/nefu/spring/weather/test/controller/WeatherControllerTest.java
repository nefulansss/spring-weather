package com.nefu.spring.weather.test.controller;

import com.alibaba.fastjson.JSON;
import com.nefu.spring.weather.SpringWeahterApplication;
import com.nefu.spring.weather.controller.WeatherController;
import com.nefu.spring.weather.util.JsonResult;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @program: spring-weather
 * @description:
 * @author: nefulan
 * @create: 2020-03-21 19:09
 **/
@SpringBootTest(classes = SpringWeahterApplication.class)
@RunWith(SpringRunner.class)
public class WeatherControllerTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherControllerTest.class);
    @Autowired
    private WeatherController weatherController;


    /**
     * 各个城市数据
     */
    @Test
    public void testGetCitiesToday(){
        JsonResult citiesToday = weatherController.getCitiesToday();
        LOGGER.info("各个城市数据：{}", JSON.toJSONString(citiesToday));
        Assert.assertNotNull(citiesToday);
    }

    /**
     * 折线图和饼状图
     */
    @Test
    public void getCityNowDetailTest(){
        JsonResult Hjson = weatherController.getCityNowDetail("哈尔滨市");
        LOGGER.info("折线图和饼状图：{}", JSON.toJSONString(Hjson));
        Assert.assertNotNull(Hjson);
    }
}

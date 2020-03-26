package com.nefu.spring.weather.controller;

import com.google.common.collect.Maps;
import com.nefu.spring.weather.dto.SimpleCity;
import com.nefu.spring.weather.entity.WWeather;
import com.nefu.spring.weather.service.WeatherService;
import com.nefu.spring.weather.util.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @program: spring-weather
 * @description:
 * @author: nefulan
 * @create: 2020-03-21 20:00
 **/
//@CrossOrigin
@RestController
public class WeatherController {
    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherController.class);
    @Autowired
    WeatherService weatherService;


    /**
     * 各个地区的天气
     * @return
     */
    @RequestMapping("index")
    public JsonResult getCitiesToday() {

        List<SimpleCity> list = weatherService.getCitiesToday();
        Map<String,String> map = Maps.newHashMap();
        for (SimpleCity simpleCity : list) {
            map.put(simpleCity.getCity(),simpleCity.getWeather());
        }
        if (list!=null){
            LOGGER.info("首页数据：{}",map);
            return new JsonResult(map,"成功查找",200);
        }else{
            return new JsonResult(null,"查找失败",500);
        }
    }

    /**
     * 城市
     * @param city
     * @return
     */
    @RequestMapping("city/detail")
    public JsonResult getCityNowDetail(String city){

        WWeather weather = weatherService.getCityNowDetail(city);
        if (weather!=null){
            return new JsonResult(weather,"成功查找",200);
        }else{
            return new JsonResult(null,"查找失败",500);
        }
    }
}

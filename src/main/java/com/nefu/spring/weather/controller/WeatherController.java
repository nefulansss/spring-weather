package com.nefu.spring.weather.controller;

import com.google.common.collect.Maps;
import com.nefu.spring.weather.dto.SimpleCity;
import com.nefu.spring.weather.dto.SimpleTime;
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
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @program: spring-weather
 * @description:
 * @author: nefulan
 * @create: 2020-03-21 20:00
 * @date 2020-03-27 13:44
 * @author zhanglan61
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
     * 城市饼状图和折线图
     * @param city
     * @return
     */
    @RequestMapping("city/detail")
    public JsonResult getCityNowDetail(String city){
        LOGGER.info("城市名为："+city);
        WWeather weather = weatherService.getCityNowDetail(city);
        List<SimpleTime> city7 = weatherService.getCity7Days(city);
        Map<String,Object> map = Maps.newHashMap();
        map.put("weather",weather);
        LOGGER.info("weather::",weather);
        map.put("city7",city7);
        if (map!=null){
            return new JsonResult(map,"成功查找",200);
        }else{
            return new JsonResult(null,"查找失败",500);
        }
    }


    /**
     * 上传图片
      * @param img
     * @return
     */

/*

    @RequestMapping("upload")
    public JsonResult getUpload(MultipartFile img){

    }
*/

}

package com.nefu.spring.weather.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.nefu.spring.weather.dto.SimpleCity;
import com.nefu.spring.weather.dto.SimpleTime;
import com.nefu.spring.weather.entity.WWeather;
import com.nefu.spring.weather.mapper.WWeatherMapper;
import com.nefu.spring.weather.service.WeatherService;
import com.nefu.spring.weather.util.TimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @program: spring-weather
 * @description:
 * @author: nefulan
 * @create: 2020-03-21 20:09
 **/
@Service
public class WeatherServiceImpl implements WeatherService {
    private static final String [] weathers = {"雨凇","雾凇","雾霾","霜","露","结冰","降雨","降雪","冰雹"};
    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherServiceImpl.class);


    @Resource
    private WWeatherMapper wWeatherMapper;


    /**
     * 各个市区
     * @return
     */
    @Override
    public List<SimpleCity> getCitiesToday() {
        Map<Long,String> map = Maps.newHashMap();
        List<WWeather> wCities = wWeatherMapper.getCitiesToday(TimeUtil.getTodayZeroDate());
        List<SimpleCity> list = new ArrayList<>();
        LOGGER.info("wCities::{}",wCities);
        for (WWeather wCity : wCities) {
            SimpleCity simpleCity = new SimpleCity();
            simpleCity.setCity(wCity.getCityName());
            simpleCity.setWeather(maxWeather(wCity));
            list.add(simpleCity);
        }

        return list;
    }

    private String maxWeather(WWeather wCity) {
        String weather = weathers[0];
        BigDecimal max = wCity.getWeather1();
        if (max.compareTo(wCity.getWeather2())<0){
            max = wCity.getWeather2();
            weather = weathers[1];
        }
        if (max.compareTo(wCity.getWeather3())<0){
            max = wCity.getWeather3();
            weather = weathers[2];
        }
        if (max.compareTo(wCity.getWeather4())<0){
            max = wCity.getWeather2();
            weather = weathers[3];
        }
        if (max.compareTo(wCity.getWeather5())<0){
            max = wCity.getWeather2();
            weather = weathers[4];
        }
        if (max.compareTo(wCity.getWeather6())<0){
            max = wCity.getWeather2();
            weather = weathers[5];
        }if (max.compareTo(wCity.getWeather7())<0){
            max = wCity.getWeather2();
            weather = weathers[6];
        }
        if (max.compareTo(wCity.getWeather8())<0){
            max = wCity.getWeather2();
            weather = weathers[7];
        }
        if (max.compareTo(wCity.getWeather9())<0){
            max = wCity.getWeather2();
            weather = weathers[8];
        }

        return weather;



    }

    /**
     * 取最新的值 饼状图
     * @param city
     * @return
     */
    @Override
    public WWeather getCityNowDetail(String city) {
        WWeather wWeather = wWeatherMapper.getCityNowDetail(city);
        return wWeather;
    }

    /**
     * 近你七天的数据 折线图
     * @param city
     * @return
     */
    @Override
    public List<SimpleTime> getCity7Days(String city) {
       List<WWeather > list = wWeatherMapper.getCity7Days(city);
        List<String> monthAndDayCurrent7 = TimeUtil.getMonthAndDayCurrent7(new Date());
        List<SimpleTime> res = Lists.newArrayList();
        int n = list.size();
        for (int i=0;i< n;i++) {
            SimpleTime simpleTime = new SimpleTime();
            simpleTime.setDate(monthAndDayCurrent7.get(i));
            simpleTime.setName(list.get(i).getCityName());
            simpleTime.setWaether(maxWeather(list.get(i)));
            res.add(simpleTime);
        }
        return res;
    }


}

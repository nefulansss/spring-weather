package com.nefu.spring.weather.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.nefu.spring.weather.dto.SimpleCity;
import com.nefu.spring.weather.entity.WWeather;
import com.nefu.spring.weather.mapper.WWeatherMapper;
import com.nefu.spring.weather.service.WeatherService;
import com.nefu.spring.weather.util.TimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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


    @Autowired
    private WWeatherMapper wWeatherMapper;


    @Override
    public List<SimpleCity> getCitiesToday() {
        Map<Long,String> map = Maps.newHashMap();
        List<WCity> wCities = wCityMapper.selectAll();
        LOGGER.info("wCities::{}",wCities);
        for (WCity wCity : wCities) {
            map.put(wCity.getCityId(),wCity.getCityName());
        }
        List<WWeather> wWeatherList = wWeatherMapper.getCitiesToday(TimeUtil.getTodayZeroDate());
        List<SimpleCity> simpleCityList = Lists.newArrayList();
        for (WWeather wWeather : wWeatherList) {
            SimpleCity simpleCity = new SimpleCity();
            simpleCity.setCity(map.get(wWeather.getCityId()));
            simpleCity.setWeather(getWeatherName(wWeather));
            simpleCityList.add(simpleCity);
        }
        return simpleCityList;
    }

    /**
     * 取最新的值
     * @param city
     * @return
     */
    @Override
    public WWeather getCityNowDetail(String city) {
        // WCity wcity = wCityMapper.selectIdByName(city);
        WCity wcity = new WCity();
        wcity.setCityId(Long.valueOf(1));
        LOGGER.info("城市id {}",wcity.getCityId());
        WWeather weather = wWeatherMapper.selectWeatherByCityAndNow(wcity.getCityId());
        LOGGER.info("城市id {}",weather);
        return weather;
    }

    /**
     * 取出最大概率的天气并返回名字
     * @param weather
     * @return
     */
    private String getWeatherName(WWeather weather){
        List<BigDecimal> list = Lists.newArrayList();
        list.add(weather.getWeather1());
        list.add(weather.getWeather2());
        list.add(weather.getWeather3());
        list.add(weather.getWeather4());
        list.add(weather.getWeather5());
        list.add(weather.getWeather6());
        list.add(weather.getWeather7());
        list.add(weather.getWeather8());
        BigDecimal max = Collections.max(list);
        for (int i=0;i<list.size();i++){
            if (max.equals(list.get(i))){
                return weathers[i];
            }
        }
        return null;
    }

}

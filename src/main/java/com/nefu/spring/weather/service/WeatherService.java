package com.nefu.spring.weather.service;

import com.nefu.spring.weather.dto.SimpleCity;
import com.nefu.spring.weather.entity.WWeather;

import java.util.List;

/**
 * @program: spring-weather
 * @description:
 * @author: nefulan
 * @create: 2020-03-21 20:09
 **/

public interface WeatherService {
    List<SimpleCity> getCitiesToday();

    WWeather getCityNowDetail(String city);
}

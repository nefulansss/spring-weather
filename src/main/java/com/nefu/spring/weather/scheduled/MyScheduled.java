package com.nefu.spring.weather.scheduled;


import com.nefu.spring.weather.entity.WWeather;
import com.nefu.spring.weather.mapper.WWeatherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: carbage
 * @description:
 * @author: nefulan
 * @create: 2020-03-26 15:33
 **/
@Component
public class MyScheduled {
    private static final String[] weathers = {"雨凇","雾凇","雾霾","霜","露","结冰","降雨","降雪","冰雹"};
    private static final String[] streets = {"哈尔滨", "牡丹江", "牡丹江市","鸡西市","七台河市",
    "双鸭山市","佳木斯市","鹤岗市","伊春市","绥化市","黑河市","大庆市",
    "齐齐哈尔市","大兴安岭地区"};

    @Autowired
    WCityMapper wCityMapper;

    @Autowired
    WWeatherMapper wWeatherMapper;


    @Scheduled(cron = "0/10 * * * * ?")
    @Transactional
    public void insertSql() {
        for (String street : streets) {
            WWeather weather = new WWeather();

        }


    }

}

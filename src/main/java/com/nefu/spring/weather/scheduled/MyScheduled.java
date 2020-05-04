package com.nefu.spring.weather.scheduled;


import com.alibaba.fastjson.JSON;
import com.nefu.spring.weather.controller.WeatherController;
import com.nefu.spring.weather.entity.WWeather;
import com.nefu.spring.weather.mapper.WWeatherMapper;
import com.nefu.spring.weather.util.TimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

/**
 * @program: carbage
 * @description:
 * @author: nefulan
 * @create: 2020-03-26 15:33
 **/
@Component
public class MyScheduled {
    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherController.class);
    private static final String[] weathers = {"雨凇","雾凇","雾霾","霜","露","结冰","降雨","降雪","冰雹"};
    private static final String[] cities = {"哈尔滨市", "牡丹江市","鸡西市","七台河市",
    "双鸭山市","佳木斯市","鹤岗市","伊春市","绥化市","黑河市","大庆市",
    "齐齐哈尔市","大兴安岭地区"};


    @Resource
    WWeatherMapper wWeatherMapper;

    /**
     * 每日凌晨一点刷新数据
     */
    //@Scheduled(cron = "0/10 * * * * ?")
    //@Transactional(rollbackFor = Exception.class)
    public void insertSql() {
        BigDecimal [] randoms = new BigDecimal[9];
        for (String city : cities) {
            LOGGER.info("定时信息：：{}",city);
            WWeather weather = new WWeather();
            weather.setCityName(city);
            BigDecimal sum =BigDecimal.ZERO;
            for (int i=0;i<randoms.length;i++){
                randoms[i] = BigDecimal.valueOf(Math.random());
                sum = sum.add(randoms[i]);
            }
            LOGGER.info("sum: {}",sum);
            LOGGER.info("随机数:前{}", JSON.toJSONString(randoms));
            for (int i=0;i<randoms.length;i++){
                randoms[i] = randoms[i].divide(sum,4,BigDecimal.ROUND_HALF_UP);

            }
            LOGGER.info("随机数:前{}", JSON.toJSONString(randoms));
            weather.setWeather1(randoms[0]);
            weather.setWeather2(randoms[1]);
            weather.setWeather3(randoms[2]);
            weather.setWeather4(randoms[3]);
            weather.setWeather5(randoms[4]);
            weather.setWeather6(randoms[5]);
            weather.setWeather7(randoms[6]);
            weather.setWeather8(randoms[7]);
            weather.setWeather9(randoms[8]);
            weather.setWeatherTime(TimeUtil.getTodayOneDate());
            wWeatherMapper.insert(weather);

        }


    }

}

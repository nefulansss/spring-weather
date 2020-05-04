package com.nefu.spring.weather.dto;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @program: spring-weather
 * @description:
 * @author: nefulan
 * @create: 2020-03-21 17:16
 **/
@Data
public class SimpleCity implements Serializable {
    /**
     * 城市名
     */
    private String city;
    /**
     * 天气
     */
    private String weather;

}

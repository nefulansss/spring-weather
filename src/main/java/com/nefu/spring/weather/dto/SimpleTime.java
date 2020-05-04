package com.nefu.spring.weather.dto;

import lombok.Data;

/**
 * @Author: zhanglan61
 * @Date: 2020/3/27 10:54
 * @Version: 1.0
 */
@Data
public class SimpleTime  {


    /**
     * 城市名字
     */
    private String name;
    /**
     *日期
     */
    private String date;
    /**
     * 天气类别
     */
    private String waether;

}

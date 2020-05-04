package com.nefu.spring.weather;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @program: spring-weather
 * @description:
 * @author: nefulan
 * @create: 2020-03-21 14:01
 **/
@SpringBootApplication
@EnableScheduling
@MapperScan("com.nefu.spring.weather.mapper")
public class SpringWeahterApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringWeahterApplication.class,args);
    }
}

package com.nefu.spring.weather.service;

import com.nefu.spring.weather.entity.WUser;

/**
 * @program: spring-weather
 * @description:
 * @author: nefulan
 * @create: 2020-03-21 15:58
 **/

public interface UserService {


    Boolean login(WUser wUser);
}

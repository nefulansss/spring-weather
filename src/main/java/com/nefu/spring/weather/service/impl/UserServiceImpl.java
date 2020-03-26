package com.nefu.spring.weather.service.impl;

import com.nefu.spring.weather.service.UserService;
import com.nefu.spring.weather.entity.WUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nefu.spring.weather.mapper.WUserMapper;
/**
 * @program: spring-weather
 * @description:
 * @author: nefulan
 * @create: 2020-03-21 15:59
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    WUserMapper userMapper;

    @Override
    public Boolean login(WUser wUser) {
       WUser user = userMapper.selectByName(wUser.getUserName());
       if (StringUtils.equals(wUser.getPassword(),user.getPassword())){
           return true;
       }else {
           return false;
       }
    }
}

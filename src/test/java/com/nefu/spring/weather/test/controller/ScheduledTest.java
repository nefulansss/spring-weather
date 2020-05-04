package com.nefu.spring.weather.test.controller;

import com.nefu.spring.weather.SpringWeahterApplication;
import com.nefu.spring.weather.scheduled.MyScheduled;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: zhanglan61
 * @Date: 2020/3/27 11:59
 * @Version: 1.0
 */
@SpringBootTest(classes = SpringWeahterApplication.class)
@RunWith(SpringRunner.class)
public class ScheduledTest {

    @Autowired
    MyScheduled myScheduled;


    @Test
    public void insertSQLTest(){
        myScheduled.insertSql();

    }




}

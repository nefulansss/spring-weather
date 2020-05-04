package com.nefu.spring.weather.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @program: spring-weather
 * @description:
 * @author: nefulan
 * @create: 2020-03-21 20:27
 **/

public class TimeUtil {


    /**
     * 当日凌晨
     * @return
     */
    public static Date getTodayZeroDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date zero = calendar.getTime();
        return zero;
    }

    /**
     * 当日凌晨一点
     * @return
     */
    public static Date getTodayOneDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 1);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date zero = calendar.getTime();
        return zero;
    }


    /**
     * 获取本周周一
     * @return
     */
    public static Date getWeekStartDate() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return cal.getTime();
    }

    /**
     * 获取月和日
     */
    public static  String getMonthAndDate(Date date,int cur){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String res = month+"-"+(day-cur);
        return res;
    }



    public static List<String> getMonthAndDayCurrent7(Date date){
        List<String> list = new ArrayList<>(7);
        for (int i=0;i<7;i++){
            list.add(getMonthAndDate(date,-i));
        }

        return list;
    }

}

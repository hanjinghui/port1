package com.louquanapp.biz;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/9/11 11:30
 * @description:
 */
public class Test {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        ;
        int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
        if (dayofweek == 1) {
            dayofweek += 7;
        }
        cal.add(Calendar.DATE, 2 - dayofweek);

        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println(sf.format(cal.getTime()));


        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 6);




        System.out.println(sf.format(calendar.getTime()));

    }
}

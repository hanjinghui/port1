package com.louquanapp.dao.extra;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/7/3 15:36
 * @description:
 */
public class test {

    public static void main(String[] args) throws Exception{
        String oldTimeStr="2019-07-03 14:30";

        Date newTime=new Date();

        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm");

        System.out.println("@@@@@@@@@@@@@@");
        Long oldTimeLong= sf.parse(oldTimeStr).getTime();
        Long newTimeLong=System.currentTimeMillis();

        Long time=newTimeLong-oldTimeLong;

        if(time<1000*60){
            System.out.println("刚刚发布");
        }else if(time<1000*60*60){
            Long count=time/(1000*60);
            System.out.println((count+"").concat("分钟前"));

        }else if(time<1000*60*60*24){
            Long count=time/(1000*60*60);
            System.out.println((count+"").concat("小时前"));
        }else {
            Long count=time/(1000*60*60*24);
            System.out.println((count+"").concat("天前"));
        }



    }
}

package com.huhuamin.common.utils;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author 胡化敏
 * @Description:
 * @Date Create 2017/11/22 17:59
 * @Modified By:
 * @Since:
 */
public class DateUtils {

    /**
     * 获取两个时间之间的分钟差
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static double getMinSpace(Date startTime, Date endTime) {
        double tmp = ((double) (endTime.getTime() - startTime.getTime()));
        tmp = tmp / (60 * 1000);
        return tmp;
    }

    public static Date strToDate(String strDate, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }
}

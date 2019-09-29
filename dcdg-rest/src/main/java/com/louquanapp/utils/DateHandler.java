package com.louquanapp.utils;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author 胡化敏
 * @Description: 日期处理Hanlder
 * @Date Create  2019年03月26日15:23:56
 * @Modified By:
 * @Since:
 */
public class DateHandler {

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        DateFormat[] dateFormats = new SimpleDateFormat[2];
        dateFormats[0] = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormats[1] = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomMutiDateEditor(dateFormats, true));
    }
}

package com.huhuamin.common;

/**
 * @Author 胡化敏
 * @Description:
 * @Date Create 2017/11/22 19:36
 * @Modified By: 标记
 * @Since:
 */
public class HuhuaminExceptionPlan extends RuntimeException {

    public HuhuaminExceptionPlan(String message, Exception e) {
        super(message, e);
    }

    public HuhuaminExceptionPlan(String message) {
        super(message);
    }
}

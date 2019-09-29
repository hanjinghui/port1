package com.louquanapp.biz;

import com.louquanapp.dao.mapper.SystemParamMapper;

/**
 * @Auther: Huhuamin
 * @Date: 2019/4/16 11:30
 * @Description:
 */
public class SystemParamBiz {
    /**
     * 注册送邀请人积分
     */
    public static final String POINT_NUM_REGISTER = "point_num_register";
    /**
     * 消费送邀请人积分
     */
    public static final String POINT_NUM_BUYER = "point_num_buyer";
    /**
     * 注册送邀请人余额
     */
    public static final String CONSUMER_NUM_REGISTER = "consumer_num_register";
    /**
     * 购买送邀请人余额
     */
    public static final String CONSUMER_NUM_BUYER = "consumer_num_buyer";


    /**
     * 单次赠送最大积分
     */
    public static final String GAME_MAX_PER_POINT = "game_max_per_point";
    /**
     * 每天游戏赠送积分上线
     */
    public static final String GAGE_MAX_DAY_POINT = "game_max_day_point";
    public static final String SIGN_POINT = "sign_point";
    public static final String SIGN_POINT_PER = "sign_point_per";
    public static final String IP = "ip";
    public static final String TEL_PHONE = "telPhone";
    /**
     * 推广返利满足推广人数
     */
    public static final String RELATION_USER_COUNT = "relation_user_count";



    private final SystemParamMapper systemParamMapper;

    public SystemParamBiz(SystemParamMapper systemParamMapper) {
        this.systemParamMapper = systemParamMapper;
    }
}

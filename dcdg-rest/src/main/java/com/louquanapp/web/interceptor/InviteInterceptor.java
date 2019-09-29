package com.louquanapp.web.interceptor;

import com.huhuamin.common.HuhuaminException;
import com.louquanapp.biz.MessageBiz;
import com.louquanapp.biz.RegisterBiz;
import com.louquanapp.biz.payment.commons.MD5Utils;
import com.louquanapp.dao.mapper.BlacklistMapper;
import com.louquanapp.dao.mapper.MessageMapper;
import com.louquanapp.dao.mapper.OrderReturnMapper;
import com.louquanapp.dao.model.Blacklist;
import com.louquanapp.dao.model.Message;
import com.louquanapp.service.JedisService;
import com.louquanapp.utils.WebServletUtil;
import jodd.util.StringUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/**
 * @Author 胡化敏
 * @Description:
 * @Date Create 2017/11/24 14:09
 * @Modified By:
 * @Since:
 */
public class InviteInterceptor implements HandlerInterceptor {


    private static  JedisService jedisService;
    private static BlacklistMapper blacklistMapper;


    public  JedisService getJedisService(HttpServletRequest httpServletRequest) {
        if (jedisService == null) {
            synchronized (JedisService.class) {
                if (jedisService == null) {
                    jedisService = getDao(JedisService.class,httpServletRequest);
                }
            }
        }

        return jedisService;
    }
    public  BlacklistMapper getBlacklistMapper(HttpServletRequest httpServletRequest) {
        if (blacklistMapper == null) {
            synchronized (BlacklistMapper.class) {
                if (blacklistMapper == null) {
                    blacklistMapper = getDao(BlacklistMapper.class,httpServletRequest);
                }
            }
        }
        return blacklistMapper;
    }


    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        if (null != httpServletRequest.getParameter(RegisterBiz.INVITE_PHONE)) {
            Object phone = httpServletRequest.getParameter(RegisterBiz.INVITE_PHONE);
            httpServletRequest.getSession().setAttribute(RegisterBiz.INVITE_PHONE, phone);
        }
        if (null != httpServletRequest.getParameter("inviteCode")) {
            Object phone = httpServletRequest.getParameter("inviteCode");
            if (!((String) phone).equalsIgnoreCase("undefined")) {
                httpServletRequest.getSession().setAttribute(RegisterBiz.INVITE_PHONE, phone);
            }
        }

        Object deviceIdObj=httpServletRequest.getHeader("deviceId");
        //Object timestampObj=httpServletRequest.getHeader("timestamp");

        if(deviceIdObj!=null) {

            getJedisService(httpServletRequest);
            getBlacklistMapper(httpServletRequest);

            String url = httpServletRequest.getRequestURI();
            String urlSuffix = url.substring(0, url.lastIndexOf("/"));

            List<String> queryBlacklistJedis = jedisService.getList("queryBlacklistJedis");
            if (CollectionUtils.isEmpty(queryBlacklistJedis)) {
                queryBlacklistJedis = blacklistMapper.queryBlacklist();
                jedisService.setList("queryBlacklistJedis", queryBlacklistJedis);
            }
            String param = deviceIdObj.toString().concat(url);
            if (!queryBlacklistJedis.contains(urlSuffix) && !queryBlacklistJedis.contains(url)) {

                String urlParam = jedisService.getValueByKeyDb2(param);
                if (StringUtils.isNotBlank(urlParam)) {
                    throw new HuhuaminException("请不要重复提交");
                } else {
                    jedisService.setKeyValuePexpireDb2(param, "url", 1000);// 一秒点击一次

                }
            }

        }
        return true;
    }

    //获取dao,拦截器中只能通过webapplicationcontextutils获取spring boot中的bean.
    private <T> T  getDao(Class<T> t,HttpServletRequest request){
        BeanFactory beanFactory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        return beanFactory.getBean(t);

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}

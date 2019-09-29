package com.louquanapp.web.exception;

import com.alibaba.fastjson.JSON;
import com.huhuamin.common.HuhuaminExceptionPlan;
import com.huhuamin.common.model.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author 胡化敏
 * @Description:
 * @Date Create 2017/11/27 09:24
 * @Modified By:
 * @Since:
 */

public class HuhuaminExceptionHandler implements HandlerExceptionResolver {
    private static final Logger logger = LoggerFactory.getLogger(HuhuaminExceptionHandler.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception ex) {
        JsonResult jsonResult = new JsonResult(false);
        Map<String, Object> model = new HashMap<String, Object>();
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        jsonResult.setMessage(ex.getMessage());
        if ("org.apache.catalina.connector.ClientAbortException".equals(ex.getClass().getName())) {
            logger.error("发生clientAbortException");
            return null;
        }
        if (!ex.getMessage().contains("token过期") && !(ex instanceof HuhuaminExceptionPlan)) { //记录日志条件
            logger.error(ex.getMessage(), ex);
        } else {
            logger.error(ex.getMessage());
        }
        String uri = httpServletRequest.getRequestURI();
        if (uri.indexOf("/api") > -1) {

            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setContentType("application/json;charset=UTF-8");
            model.put("jsonStr", JSON.toJSONString(jsonResult));

            return new ModelAndView("json", model);

        } else {

            model.put("ex", ex);
            model.put("message", ex.getMessage());
            return new ModelAndView("500", model);
        }


    }
}

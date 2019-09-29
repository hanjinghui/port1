package com.louquanapp.web.exception;

import com.huhuamin.common.HuhuaminExceptionPlan;
import com.huhuamin.common.model.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理所有不可知的异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    JsonResult handleException(Exception e) {
        if ("org.apache.catalina.connector.ClientAbortException".equals(e.getClass().getName())) {
            LOGGER.error("发生clientAbortException");
            return null;
        }
        if (!e.getMessage().contains("token过期") && !(e instanceof HuhuaminExceptionPlan)) {
            LOGGER.error(e.getMessage(), e);
        } else {
            LOGGER.error(e.getMessage());
        }


        JsonResult jsonResult = new JsonResult(false);
        String message = e.getMessage();
        if (e.getMessage().lastIndexOf("field :") > -1) {
            message = message.substring(message.lastIndexOf("field :"), message.length()).concat("类型不正确").replace("field", "请求参数");
        }
        if (message.contains("token") && message.contains("过期")) {
            jsonResult.setCode(301);
        }
        jsonResult.setMessage(message);
        return jsonResult;
    }

}

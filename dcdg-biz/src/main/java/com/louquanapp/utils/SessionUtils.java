package com.louquanapp.utils;

import com.huhuamin.common.model.HhmConstants;
import com.huhuamin.common.model.JsonResult;
import com.huhuamin.common.utils.Arith;
import com.huhuamin.common.utils.DateUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author 胡化敏(huhuamin)
 * @email 175759041@qq.com
 * @date 2018/5/31 下午5:07
 */
public class SessionUtils {

    /**
     * 验证发送验证码
     *
     * @param jsonResult
     * @param session
     * @param message_effective_time
     * @return
     */
    public static JsonResult handleSesseionValid(JsonResult jsonResult, HttpSession session, int message_effective_time, boolean off_line) {
        jsonResult.setStatusCode(false);
//        if (off_line) {
//            jsonResult.setStatusCode(true);
//            return jsonResult;
//        }
        Date beforeDate = (Date) session.getAttribute(HhmConstants.SERVER_TIME);
        String serverTarget = (String) session.getAttribute(HhmConstants.TARGET_NUMBER);
        if (null == beforeDate || StringUtils.isBlank(serverTarget)) {
            jsonResult.setMessage("验证码未发送或无效，请重新发送");
            return jsonResult;
        }

        Date nowDate = new Date();// 服务器当前时间
        double minSpace = DateUtils.getMinSpace(beforeDate, nowDate);// 获取当前时间和发送验证码时间之间的分钟差
        if (Arith.compareDoubleSize(minSpace, message_effective_time) > 0) {// 两次间隔时间差与短信有效时间比较，
            jsonResult.setMessage("验证码未发送或无效，请重新发送");
            return jsonResult;
        }
        jsonResult.setStatusCode(true);
        return jsonResult;
    }


    public static String phoneEncryption(String mobile){
        char[] m = mobile.toCharArray();
        for (int i = 0; i < m.length; i++) {
            if (i > 2 && i < 7) {
                m[i] = '*';
            }
        }
        return String.valueOf(m);
    }
}

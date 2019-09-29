package com.louquanapp.utils;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.huhuamin.common.model.HhmConstants;
import com.huhuamin.common.utils.UUIDUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @Auther: Huhuamin
 * @Date: 2019/3/26 16:42
 * @Description: 阿里云发送短信
 */
public class SendMessageClient {
    private static IAcsClient client = null;
    private static DefaultProfile profile = null;

    static {
        profile = DefaultProfile.getProfile("default", "LTAIxwpfltO8WgBK", "qhdAkf9fRGwF8iEgQGVT0xUU1018aW");
        client = new DefaultAcsClient(profile);
    }


    public static String sendValidCode(HttpSession session, String target, String contentTempLate, String preFixValid) {
        String validCode = UUIDUtils.generateValidCode();

        //您的注册验证码为：#{valid_code}，请继续完成注册操作。(本短信仅用于菜篮子安徽短信验证，如非本人操作，请忽略)
        if (StringUtils.isNotBlank(preFixValid)) {
            session.setAttribute(preFixValid.concat(HhmConstants.VALID_CODE), validCode);
            session.setAttribute(HhmConstants.PRE_FIX_PHONE_REG.concat(HhmConstants.VALID_CODE), validCode);
        } else {
            session.setAttribute(HhmConstants.VALID_CODE, validCode);
        }

        session.setAttribute(HhmConstants.SERVER_TIME, new Date());
        session.setAttribute(HhmConstants.TARGET_NUMBER, target);
        realSend(target, contentTempLate, validCode);
        return validCode;
    }


    public static void realSend(String PhoneNumbers, String TemplateCode, String valid) {
        CommonRequest request = new CommonRequest();
        //request.setProtocol(ProtocolType.HTTPS);
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("PhoneNumbers", PhoneNumbers);
        request.putQueryParameter("TemplateCode", TemplateCode);
        request.putQueryParameter("TemplateParam", "{\"code\":" + valid + "}");
        request.putQueryParameter("SignName", "搂圈");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }


}

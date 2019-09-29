package com.louquanapp.web.basic.api;

import com.huhuamin.common.HuhuaminException;
import com.huhuamin.common.HuhuaminExceptionPlan;
import com.louquanapp.model.TypeJsonResult;
import com.louquanapp.req.ReqImgWithCode;
import com.louquanapp.service.JedisService;
import com.louquanapp.utils.ImageAndQRcode;
import com.louquanapp.utils.OssLocalClientUtils;
import com.louquanapp.web.customer.api.AuthCustomerApi;
import org.springframework.util.ClassUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;

/**
 * @Auther: Huhuamin
 * @Date: 2019/5/14 15:44
 * @Description:
 */
@RestController
@RequestMapping("/api/auth")
public class ImageController {

    private final JedisService jedisService;

    public ImageController(JedisService jedisService) {
        this.jedisService = jedisService;
    }

    @RequestMapping("/imgWithCode")
    public TypeJsonResult<String> imgWithCode(@Valid @RequestBody ReqImgWithCode reqSource, BindingResult bindingResult) {
        try {
            TypeJsonResult<String> typeJsonResult = new TypeJsonResult<>();
            String custId = jedisService.getCustIdByToken(reqSource.getToken());
            if (AuthCustomerApi.tokenDie(typeJsonResult, custId)) return typeJsonResult;
            String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
            String t = Thread.currentThread().getContextClassLoader().getResource("").getPath();
            String outPath = String.valueOf(new Date().getTime()) + ".png";
            //1000 1500
            //isBackground 是否融入背景[1-有背景 2-没有背景]

            ImageAndQRcode.zxingCodeCreateImage(1,reqSource.getText(), 412, 412, path + "bg.jpg", path + outPath, "169", "461");


            String ossFilename = OssLocalClientUtils.convertPathToOssObject(path + outPath);
            ImageAndQRcode.removeTempFile(path + outPath);
            typeJsonResult.setType(ossFilename);
            typeJsonResult.setStatusCode(true);
            return typeJsonResult;
        } catch (Exception e) {
            String msg = "二维码合成背景";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg + e.getMessage(), e);
        }

    }

    public static String getCouponImg(String text) {
        try {
            String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
            String t = Thread.currentThread().getContextClassLoader().getResource("").getPath();
            String outPath = String.valueOf(new Date().getTime()) + ".png";
            //1000 1500
            //isBackground 是否融入背景[1-有背景 2-没有背景]

            ImageAndQRcode.zxingCodeCreateImage(2,text, 412, 412, path + "bg.jpg", path + outPath, "169", "461");


            String ossFilename = OssLocalClientUtils.convertPathToOssObject(path + outPath);
            ImageAndQRcode.removeTempFile(path + outPath);
            return ossFilename;
        } catch (Exception e) {
            String msg = "二维码合成";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg + e.getMessage(), e);
        }

    }

}

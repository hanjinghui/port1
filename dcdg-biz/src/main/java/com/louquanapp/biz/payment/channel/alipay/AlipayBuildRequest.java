package com.louquanapp.biz.payment.channel.alipay;




import com.louquanapp.biz.payment.constants.AliPaymentConfig;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;


public class AlipayBuildRequest {

    /**
     * 生成签名结果
     *
     * @param sPara 要签名的数组
     * @return 签名结果字符串
     */
    public static String buildRequestPara(Map<String, String> sPara, AliPaymentConfig aliConfig) {
        String prestr = AlipayCore.createAlipayMobileLinkString(sPara); //把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串
        String mysign = "";
        mysign = SignUtils.sign(prestr, aliConfig.getPrivate_key(), false);
        try {
            mysign = URLEncoder.encode(mysign, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return prestr + "&sign=\"" + mysign + "\"&sign_type=\"RSA\"";
    }


    /**
     * 建立请求，返回Map列表
     *
     * @param sParaTemp 请求参数数组
     * @return 提交表单HTML文本
     */
    public static String buildRequestParam(Map<String, String> sParaTemp, AliPaymentConfig aliConfig) {
        //待请求参数数组
        String sPara = buildRequestPara(sParaTemp, aliConfig);

        return sPara;
    }

}

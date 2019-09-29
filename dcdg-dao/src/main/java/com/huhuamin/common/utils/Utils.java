package com.huhuamin.common.utils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * @Author 胡化敏
 * @Description:
 * @Date Create 2017/11/24 14:41
 * @Modified By:
 * @Since:
 */
public class Utils {

    /**
     * 2进制转输入流
     *
     * @param bytes1
     * @return
     */
    public static InputStream BaseToInputStream(byte[] bytes1) {
        ByteArrayInputStream stream = null;
        try {
            stream = new ByteArrayInputStream(bytes1);
        } catch (Exception e) {
        }
        return stream;

    }
}

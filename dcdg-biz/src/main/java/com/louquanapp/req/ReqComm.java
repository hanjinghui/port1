package com.louquanapp.req;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * 公共业务模块
 */
public class ReqComm {
    /**
     * 设备id
     */
    @NotNull(message = "deviceId不能为空")
    private String deviceId;
    /**
     * 时间戳
     */
    @NotNull(message = "timestamp不能为空")
    private Long timestamp;
    /**
     * 来源[1-微信 2-WAP 3-Android 4-iOS 5-pc]
     */
    ///来源[1-微信 2-WAP 3-Android 4-iOS 5-pc]
    @NotNull(message = "registerSource不能为空")
    @Range(min = 1, max = 5, message = "registerSource范围是1-5")
    private Byte registerSource;


    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }


    /**
     * 来源[1-微信 2-WAP 3-Android 4-iOS 5-pc]
     *
     * @return
     */
    public Byte getRegisterSource() {
        return registerSource;
    }

    /**
     * 来源[1-微信 2-WAP 3-Android 4-iOS 5-pc]
     *
     * @param registerSource
     */
    public void setRegisterSource(Byte registerSource) {
        this.registerSource = registerSource;
    }
}

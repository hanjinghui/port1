package com.louquanapp.web.customer.api;

import com.alibaba.fastjson.JSON;
import com.huhuamin.common.model.HhmConstants;
import com.huhuamin.common.model.JsonResult;
import com.louquanapp.biz.BasicVersionsBiz;
import com.louquanapp.biz.CustomerBiz;
import com.louquanapp.biz.RegisterBiz;
import com.louquanapp.biz.ThirdLoginBiz;
import com.louquanapp.dao.model.Customer;
import com.louquanapp.model.TypeJsonResult;
import com.louquanapp.req.*;
import com.louquanapp.utils.SendMessageClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@RestController
@RequestMapping("/api/no")
public class BasicVersionsApi {
    private final Logger logger = LoggerFactory.getLogger(BasicVersionsApi.class);
    private final BasicVersionsBiz basicVersionsBiz;

    public BasicVersionsApi(BasicVersionsBiz basicVersionsBiz) {
        this.basicVersionsBiz = basicVersionsBiz;
    }

    /**
     * 获取版本
     * @param type [1-android 2-ios]
     * @param bindingResult
     * @return
     */
    @PostMapping("/basicVersion/{type}")
    public JsonResult basicVersions(@PathVariable("type") Integer type, @RequestBody @Valid ReqComm reqComm, BindingResult bindingResult) {
        return basicVersionsBiz.basicVersion(type);
    }

}

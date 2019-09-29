package com.louquanapp.biz;

import com.alibaba.fastjson.JSON;
import com.huhuamin.common.HuhuaminException;
import com.huhuamin.common.model.HhmConstants;
import com.huhuamin.common.model.JsonResult;
import com.huhuamin.common.utils.UUIDUtils;
import com.louquanapp.dao.mapper.*;
import com.louquanapp.dao.model.Customer;
import com.louquanapp.dao.model.CustomerAccount;
import com.louquanapp.dao.model.CustomerPoint;
import com.louquanapp.dao.model.SystemParam;
import com.louquanapp.model.TypeJsonResult;
import com.louquanapp.req.ReqRegister;
import com.louquanapp.req.ReqRegisterNophone;
import com.louquanapp.service.JedisService;
import com.louquanapp.utils.SessionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Service
public class BasicVersionsBiz {
    private static final Logger logger = LoggerFactory.getLogger(BasicVersionsBiz.class);
    private final BasicVersionMapper basicVersionMapper;

    public BasicVersionsBiz(BasicVersionMapper basicVersionMapper) {
        this.basicVersionMapper = basicVersionMapper;
    }

    /**
     * app版本信息
     * @return
     */
    public TypeJsonResult basicVersion( Integer type) {
        TypeJsonResult jsonResult=new TypeJsonResult();

        jsonResult.setType(basicVersionMapper.queryBasicVersionByType(type));
        jsonResult.setStatusCode(true);
        return jsonResult;

    }


}
package com.louquanapp.web.basic.api;


import com.huhuamin.common.model.JsonResult;
import com.louquanapp.biz.FeedbackBiz;
import com.louquanapp.dao.mapper.CustomerMapper;
import com.louquanapp.dao.model.Customer;
import com.louquanapp.req.ReqFeedback;
import com.louquanapp.service.JedisService;
import com.louquanapp.utils.BizUtils;
import com.louquanapp.web.customer.api.AuthCustomerApi;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Auther: Huhuamin
 * @Date: 2019/4/11 08:01
 * @Description: 意见反馈
 */
@RestController
@RequestMapping("/api/auth")
public class FeedbackController {

    private final FeedbackBiz feedbackBiz;
    private final JedisService jedisService;
    private final CustomerMapper customerMapper;

    public FeedbackController(FeedbackBiz feedbackBiz, JedisService jedisService, CustomerMapper customerMapper) {
        this.feedbackBiz = feedbackBiz;
        this.jedisService = jedisService;
        this.customerMapper = customerMapper;
    }


    @PostMapping("feedback")
    public JsonResult feedback(@RequestBody @Valid ReqFeedback reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(false);
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        Customer customer = customerMapper.selectNickNameAndRealNameAndPhoneAndPwdByPrimaryKey(custId);
        return feedbackBiz.feedback(reqSource, custId, BizUtils.getCustName(customer));

    }


}

package com.louquanapp.biz;


import com.huhuamin.common.HuhuaminException;
import com.huhuamin.common.model.JsonResult;
import com.huhuamin.common.utils.UUIDUtils;
import com.louquanapp.dao.mapper.FeedbackMapper;
import com.louquanapp.dao.model.Feedback;
import com.louquanapp.req.ReqFeedback;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Auther: Huhuamin
 * @Date: 2019/4/11 07:58
 * @Description: 意见反馈
 */
@Service
public class FeedbackBiz {
    private final FeedbackMapper feedbackMapper;

    public FeedbackBiz(FeedbackMapper feedbackMapper) {
        this.feedbackMapper = feedbackMapper;
    }


    public JsonResult feedback(ReqFeedback reqSource, String custId, String custName) {
        try {
            JsonResult jsonResult = new JsonResult(false);
            //处理评价图片
            String ossImgs = reqSource.getFeedbackImg();
            Feedback feedback = new Feedback();
            feedback.setAddTime(new Date());
            feedback.setCustId(custId);
            feedback.setCustName(custName);
            feedback.setCustPhone(reqSource.getCustPhone());
            feedback.setFeedbackCont(reqSource.getFeedbackCont());
            feedback.setFeedbackId(UUIDUtils.generateUuid22());
            feedback.setFeedbackImg(ossImgs);
            feedback.setDealStatus((byte) 1);
            int rgCount = feedbackMapper.insert(feedback);
            if (rgCount == 0) {
                jsonResult.setStatusCode(false);
                jsonResult.setMessage("保存数据库失败");
                return jsonResult;
            }
            jsonResult.setStatusCode(true);
            return jsonResult;
        } catch (Exception e) {
            throw new HuhuaminException("保存意见反馈异常", e);
        }
    }
}

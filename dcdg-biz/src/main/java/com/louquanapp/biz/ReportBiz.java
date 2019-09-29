package com.louquanapp.biz;

import com.huhuamin.common.HuhuaminException;
import com.huhuamin.common.HuhuaminExceptionPlan;
import com.huhuamin.common.model.JsonResult;
import com.huhuamin.common.utils.UUIDUtils;
import com.louquanapp.dao.mapper.CustomerMapper;
import com.louquanapp.dao.mapper.ReportMapper;
import com.louquanapp.dao.mapper.VideoMapper;
import com.louquanapp.dao.model.Customer;
import com.louquanapp.dao.model.Report;
import com.louquanapp.dao.model.Video;
import com.louquanapp.req.ReqDoReport;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Auther: Huhuamin
 * @Date: 2019/5/6 19:08
 * @Description:
 */
@Service
public class ReportBiz {

    private final ReportMapper reportMapper;
    private final VideoMapper videoMapper;
    private final CustomerMapper customerMapper;

    public ReportBiz(ReportMapper reportMapper, VideoMapper videoMapper, CustomerMapper customerMapper) {
        this.reportMapper = reportMapper;
        this.videoMapper = videoMapper;
        this.customerMapper = customerMapper;
    }

    public JsonResult doReport(ReqDoReport reqSource, String custId) {

        try {
            JsonResult jsonResult = new JsonResult(false);

            Date now = new Date();

            Report report = new Report();
            report.setReportId(UUIDUtils.generateUuid22());
            report.setCustId(custId);
            report.setAddTime(now);
            report.setUpdateTime(now);
            report.setCatName(reqSource.getCatName());
            Video video = videoMapper.selectByPrimaryKey(reqSource.getVideoId());
            if (null == video) {
                jsonResult.setMessage("你举报的视频不存在");
                return jsonResult;
            }

            Customer customer = customerMapper.selectNickNameAndRealNameAndPhoneAndPwdByPrimaryKey(custId);
            report.setCustedId(video.getCustId());
            report.setCustPhone(customer.getCustPhone());
            report.setReportContent(reqSource.getReportContent());
            report.setReportFlag((byte) 1);
            report.setVideoNo(video.getVideoNo());
            reportMapper.insert(report);

            jsonResult.setStatusCode(true);
            return jsonResult;
        } catch (Exception e) {
            String msg = "举报";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }
    }
}
